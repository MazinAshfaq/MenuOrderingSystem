import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DinnerTest {
    @Test
    void propertiesAreSetOnOrderConstructor() {
        int[] testOrderIntArray = {1,2,3,4};

        Dinner testDinner = new Dinner(testOrderIntArray);

        assertEquals("Steak",testDinner.getMain());
        assertEquals("Potatoes",testDinner.getSide());
        assertEquals("Wine, Water",testDinner.getDrink());
        assertEquals("Cake", testDinner.getDessert());
    }

    @Test
    void shouldReturnTrueIfDessertIsMissing(){
        int[] testOrderIntArray = {1,2,3,4};
        Dinner testDinner = new Dinner(testOrderIntArray);
        int[] testOrderIntArrayMissingDessert = {1,2,3};

        assertTrue(testDinner.dessertMissing(testOrderIntArrayMissingDessert));

    }

    @Test
    void shouldReturnFalseIfDessertIsNotMissing(){
        int[] testOrderIntArray = {1,2,3,4};
        Dinner testDinner = new Dinner(testOrderIntArray);
        int[] testOrderIntArrayMissingDessert = {1,2,3,4};

        assertFalse(testDinner.dessertMissing(testOrderIntArrayMissingDessert));

    }
}