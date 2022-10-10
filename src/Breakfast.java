import java.util.function.Supplier;

public class Breakfast extends Order {

    public Breakfast(int[] orderNumbers) throws IllegalArgumentException {

        super(null, null, null);

        if (super.checkMainAndSideMissing(orderNumbers)) {
            throw new IllegalArgumentException();
        }

        if (super.countMultipleOrders(orderNumbers, 1) > 1) {
            System.out.println("Unable to process: Eggs cannot be ordered more than once");
        }
        if (super.countMultipleOrders(orderNumbers, 2) > 1) {
            System.out.println("Unable to process: Toast cannot be ordered more than once");
        }

        super.setMain("Eggs");
        super.setSide("Toast");

        if (!super.hasDrink(orderNumbers)) {
            super.setDrink("water");
        } else {
            int count = super.countMultipleOrders(orderNumbers, 3);
            String drink = "Coffee(" + Integer.toString(count) + ")";
            super.setDrink(drink);
        }

    }

    public void printOrder() {
        System.out.println(super.getMain() + "," + super.getSide() + "," + super.getDrink());
    }

}
