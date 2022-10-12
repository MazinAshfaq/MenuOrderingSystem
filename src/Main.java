import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void printMenu(){
        System.out.println("Breakfast\nMain      Side      Drink\n1:Eggs    2:Toast   3:Coffee\n\nLunch\n" +
                "Main           Side      Drink\n1:Sandwich     2:Chips   3:Soda\n\nDinner\nMain         Side        Drink" +
                "      Dessert\n1:Steak      2:Potatoes  3:Wine     4:Cake\n");
    }

    public static int[] parseOrderNumbers(String[] ordersStringArray) {

        int[] orderNumbersIntArray = Arrays.stream(ordersStringArray).mapToInt(Integer::parseInt).toArray();
        return orderNumbersIntArray;
    }

    public static Boolean validateInput(String mealTime, int[] orderNumbersIntArray) {
        // Create meal times list to check input against
        String[] mealTimesArray = new String[] { "breakfast", "lunch", "dinner" };
        List<String> list = Arrays.asList(mealTimesArray);

        // Check if mealtime is entered correctly
        if (!list.contains(mealTime.toLowerCase())) {
            System.out.println(
                    "\nPlease enter a valid meal time. (EX: Breakfast, Lunch or Dinner)");

            return false;
        }

        int limit = 0;
        // Check if any of the order numbers do not exist.
        if (mealTime.equals("breakfast") || mealTime.equals("lunch")) {
            limit = 3;
        } else {
            limit = 4;
        }
        for (int i = 0; i < orderNumbersIntArray.length; i++) {
            if (orderNumbersIntArray[i] > limit) {
                System.out.println("\nOne of the items in your order does not exist\n");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Boolean valid = false;
        String mealTime;
        int[] orderNumbers = {};

        do {
            printMenu();
            System.out.println(
                    "Please enter the meal followed by ids of food seperated with commas from its menu! (EX: Breakfast 1,2,3)\n");

            // Grab and save user input
            String userInput = cin.nextLine();
            String stringArr[] = userInput.split(" ");

            mealTime = stringArr[0].toLowerCase();
            // Convert string of order numbers to int array
            try {
                if (stringArr.length > 1) {
                    orderNumbers = parseOrderNumbers(stringArr[1].split(","));
                }

            } catch (NumberFormatException e) {
                System.out.println("Bad order input");
                break;
            }

            valid = validateInput(mealTime, orderNumbers);

            if (valid) {
                try {
                    if (mealTime.equals("breakfast")) {
                        Breakfast order = new Breakfast(orderNumbers);
                        order.printOrder();
                    } else if (mealTime.equals("lunch")) {
                        Lunch order = new Lunch(orderNumbers);
                        order.printOrder();
                    } else {
                        Dinner order = new Dinner(orderNumbers);
                        order.printOrder();
                    }
                } catch (Exception e) {
                    valid = false;
                }
            }

        } while (valid != true);
    }
}