public class Dinner extends Order {
    private String dessert;

    public String getDessert() {
        return this.dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public Dinner(int[] orderNumbers) {
        super(null, null, null);

        if (super.checkMainAndSideMissing(orderNumbers)) {
            throw new IllegalArgumentException();
        }

        if (dessertMissing(orderNumbers)) {
            throw new IllegalArgumentException();
        }

        if (super.countMultipleOrders(orderNumbers, 1) > 1) {
            System.out.println("Unable to process: Steak cannot be ordered more than once");
        }
        if (super.countMultipleOrders(orderNumbers, 2) > 1) {
            System.out.println("Unable to process: Potatoes cannot be ordered more than once");
        }
        if (super.countMultipleOrders(orderNumbers, 3) > 1) {
            System.out.println("Unable to process: Wine cannot be ordered more than once");
        }
        if (super.countMultipleOrders(orderNumbers, 4) > 1) {
            System.out.println("Unable to process: Dessert cannot be ordered more than once");
        }

        super.setMain("Steak");
        super.setSide("Potatoes");

        if (!super.hasDrink(orderNumbers)) {
            super.setDrink("Water");
        } else {
            String drink = "Wine, Water";
            super.setDrink(drink);
        }
        this.setDessert("Cake");

    }

    public boolean dessertMissing(int[] orderNumbers) {
        if (!super.contains(orderNumbers, 4)) {
            System.out.println("\nUnable to process: Dessert is missing");
            return true;
        }
        return false;
    }

    public void printOrder() {
        System.out.println(super.getMain() + "," + super.getSide() + "," + super.getDrink() + "," + this.getDessert());
    }

}