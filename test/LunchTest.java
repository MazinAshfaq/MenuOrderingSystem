import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LunchTest {

    @Test
    void propertiesAreSetOnOrderConstructor() {
        int[] testOrderIntArray = {1,2,3};
        Lunch testLunch = new Lunch(testOrderIntArray);

        assertEquals("Sandwich",testLunch.getMain());
        assertEquals("Chips(1)",testLunch.getSide());
    }

    @Test
    void shouldReturnFourSides() {
            int[] testOrderIntArray = {1,2,2,2,2,3};
            Lunch testLunch = new Lunch(testOrderIntArray);
            assertEquals("Chips(4)",testLunch.countSides(testOrderIntArray));
    }

}