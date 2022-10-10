public class Lunch extends Order {
    private String drink;

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public Lunch(int[] orderNumbers) {
        super(null, null, null);

        if (super.checkMainAndSideMissing(orderNumbers)) {
            throw new IllegalArgumentException();
        }

        if (super.countMultipleOrders(orderNumbers, 1) > 1) {
            System.out.println("Unable to process: Sandwich cannot be ordered more than once");
        }
        if (super.countMultipleOrders(orderNumbers, 3) > 1) {
            System.out.println("Unable to process: Soda cannot be ordered more than once");
        }

        super.setMain("Sandwich");
        super.setSide(countSides(orderNumbers));

        if (!super.hasDrink(orderNumbers)) {
            super.setDrink("water");
        } else {
            super.setDrink(drink);
        }

    }

    public String countSides(int[] orderNumbers) {
        int count = super.countMultipleOrders(orderNumbers, 2);
        String side = "Chips(" + Integer.toString(count) + ")";

        return side;
    }

    public void printOrder() {
        System.out.println(super.getMain() + "," + super.getSide() + "," + super.getDrink());
    }

}