import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreakfastTest {
    @Test
    void propertiesAreSetOnOrderConstructor() {
        int[] testOrderIntArray = {1,2,3};

        Breakfast testBreakfast = new Breakfast(testOrderIntArray);

        assertEquals("Eggs",testBreakfast.getMain());
        assertEquals("Toast",testBreakfast.getSide());
        assertEquals("Coffee(1)",testBreakfast.getDrink());

    }
}