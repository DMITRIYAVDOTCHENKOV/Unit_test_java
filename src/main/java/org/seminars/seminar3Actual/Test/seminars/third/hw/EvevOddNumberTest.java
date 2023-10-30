package seminars.third.hw;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.seminars.seminar3Actual.src.seminars.third.hw.EvevOddNumber;

public class EvevOddNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 5, 7, 8})
    void even_or_not_even(int n) {

        assertEquals(EvevOddNumber.evenOddNumber(n), isEven(n));
    }

    boolean isEven(int n) {
        return n % 2 == 0;
    }
    @Test
    void checkEvenNumber() {
        assertTrue(EvevOddNumber.evenOddNumber(4));
    }
}

