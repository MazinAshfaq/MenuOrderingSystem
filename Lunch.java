public class Lunch extends Order {
    private String drink;

    public Lunch(int[] orderNumbers) {
        super(null, null);

        if (super.checkMainAndSideMissing(orderNumbers)) {
            throw new IllegalArgumentException();
        }

        if (super.countMultipleOrders(orderNumbers, 1) > 1) {
            System.out.println("Unable to process: Sandwich cannot be ordered more than once");
        }
        if (!super.hasDrink(orderNumbers)) {
            setDrink("water");
        } else {
            setDrink(drink);
        }

        super.setMain("Sandwich");
        super.setSide(countSides(orderNumbers));

    }

    public String countSides(int[] orderNumbers) {
        int count = super.countMultipleOrders(orderNumbers, 2);
        String side = "Chips(" + Integer.toString(count) + ")";

        return side;
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