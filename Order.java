// import Breakfast;
// import Lunch;
// import Dinner;

import java.util.Scanner;

import java.util.Arrays;
import java.util.List;
public class Order {
   private String main;
   private String side;

   public Order(String main, String side) {
      this.main = main;
      this.side = side;
    }

    //Default constructor
    public Order(){}

    public static Boolean validateInput(String userInput) {

      String stringArr[] = userInput.split(" ");
      String mealTime = stringArr[0];
      //Convert string of order numbers to int array
      String [] orderNumbers = stringArr[1].split(",");
      int[] orderNumbersIntArray = Arrays.stream(orderNumbers).mapToInt(Integer::parseInt).toArray();
      //Arrays.sort(orderNumbersIntArray);

      //Create meal times list to check input against
      String[] mealTimesArray = new String[]{"breakfast", "lunch", "dinner"};
      List<String> list = Arrays.asList(mealTimesArray);
    
      //Check if mealtime is entered correctly
      if (!list.contains(mealTime.toLowerCase())) {
        System.out.println(
          "\nPlease enter a valid meal time. (EX: Breakfast, Lunch or Dinner)"
        );
        return false;
    }

      //Check if any of the order numbers do not exist.
      for(int i = 0; i < orderNumbersIntArray.length; i++){
        if(orderNumbersIntArray[i] > 4){
            System.out.println("\nOne of the items in your order does not exist\n");
            return false; 
        }
      }
    //   return [meanTime, orderNumbersArray];
    return true;
    }
    
    public static void main(String[] args) { 
      Scanner cin = new Scanner(System.in);
        Boolean valid = false;
        do {
         System.out.println("Please enter the meal followed by ids of food seperated with commas from its menu! (EX: Breakfast 1,2,3)");
         String userInput = cin.nextLine();
         valid = validateInput(userInput);
        } while (valid != true);

    }

 }

