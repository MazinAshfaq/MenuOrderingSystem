import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void propertiesAreSetOnOrderConstructor() {
        Order testOrder = new Order("Eggs","Toast","Water");

        assertEquals("Eggs",testOrder.getMain());
        assertEquals("Toast",testOrder.getSide());
        assertEquals("Water",testOrder.getDrink());}

    @Test
    void shouldReturnTrueWhenMainIsMissing() {
        Order testOrder = new Order(null,null,null);
        int[] testOrderIntArray = {2};
        assertTrue(testOrder.checkMainAndSideMissing(testOrderIntArray));
    }

    @Test
    void shouldReturnTrueWhenSideIsMissing() {
        Order testOrder = new Order(null,null,null);
        int[] testOrderIntArray = {1};
        assertTrue(testOrder.checkMainAndSideMissing(testOrderIntArray));
    }

    @Test
    void shouldReturnTrueWhenMainAndSideIsMissing() {
        Order testOrder = new Order(null,null,null);
        int[] testOrderIntArray = {};
        assertTrue(testOrder.checkMainAndSideMissing(testOrderIntArray));
    }

    @Test
    void shouldReturnFalseWhenMainAndSideAreNotMissing() {
        Order testOrder = new Order(null,null,null);
        int[] testOrderIntArray = {1,2};
        assertFalse(testOrder.checkMainAndSideMissing(testOrderIntArray));
    }

    @Test
    void shouldReturnTrueWhenDrinkIsNotMissing() {
        Order testOrder = new Order(null,null,null);
        int[] testOrderIntArray = {3};
        assertTrue(testOrder.hasDrink(testOrderIntArray));
    }

    @Test
    void shouldReturnFalseWhenDrinkIsMissing() {
        Order testOrder = new Order(null,null,null);
        int[] testOrderIntArray = {};
        assertFalse(testOrder.hasDrink(testOrderIntArray));
    }

    @Test
    void countMultipleOrders() {
        Order testOrder = new Order(null,null,null);
        int[] testOrderIntArray = {4,4,4,4};
        assertEquals(4,testOrder.countMultipleOrders(testOrderIntArray,4));
    }

    @Test
    void shouldReturnTrueWhenInputContains() {
        Order testOrder = new Order(null,null,null);
        int[] testOrderIntArray = {4};
        assertTrue(testOrder.contains(testOrderIntArray,4));
    }

    @Test
    void shouldReturnFalseWhenInputContains() {
        Order testOrder = new Order(null,null,null);
        int[] testOrderIntArray = {4};
        assertFalse(testOrder.contains(testOrderIntArray,3));
    }
}