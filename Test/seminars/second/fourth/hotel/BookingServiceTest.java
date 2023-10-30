package seminars.second.fourth.hotel;


import org.junit.jupiter.api.Test;
import org.seminars.fourth.hotel.BookingService;
import org.seminars.fourth.hotel.HotelService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookingServiceTest {
    @Test
    void bookingTestPositive() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(2)).thenReturn(true);

        boolean check = bookingService.bookRoom(2);

        verify(hotelService, times(1)).isRoomAvailable(2);
        assertThat(check).isEqualTo(true);
    }

}