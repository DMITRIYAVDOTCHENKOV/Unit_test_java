package seminars.second.fourth.weather;


import org.junit.jupiter.api.Test;
import org.seminars.fourth.database.DataProcessor;
import org.seminars.fourth.database.Database;
import org.seminars.fourth.weather.WeatherReporter;
import org.seminars.fourth.weather.WeatherService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WeatherReporterTest {
    @Test
    void weatherTest() {
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);
        when(weatherService.getCurrentTemperature()).thenReturn(25);

        String report = weatherReporter.generateReport();

        verify(weatherService, times(1)).getCurrentTemperature();
        assertThat(report).isEqualTo("Текущая температура: 25 градусов.");
    }

    @Test
    void testDataProcessor() {
        Database db = mock(Database.class);
        DataProcessor dP = new DataProcessor(db);
        when(db.query(anyString())).thenReturn(Arrays.asList("строка1", "строка2"));

        List<String> result = db.query("строка");

        verify(db).query("строка");
        assertThat(result).isNotEmpty().hasSize(2).isEqualTo(Arrays.asList("строка1", "строка2"));
    }
}