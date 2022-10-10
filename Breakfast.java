import java.util.function.Supplier;

public class Breakfast extends Order {
    private String drink;

    public Breakfast(int[] orderNumbers) throws IllegalArgumentException {

        super("Eggs", "Toast");

        if (super.checkMainAndSideMissing(orderNumbers)) {
            throw new IllegalArgumentException();
        }

        if (!super.hasDrink(orderNumbers)) {
            setDrink("water");
        } else {
            int count = super.countMultipleOrders(orderNumbers, 3);
            String drink = "Coffee(" + Integer.toString(count) + ")";
            setDrink(drink);
        }

    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void printOrder() {
        System.out.println(super.getMain() + "," + super.getSide() + "," + this.getDrink());
    }

}
