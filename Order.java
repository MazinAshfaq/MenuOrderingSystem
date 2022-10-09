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
      String stringArr[] = userInput.split(" ", 2);
      String mealTime = stringArr[0];
      String[] mealTimesArray = new String[]{"breakfast", "lunch", "dinner"};
      List<String> list = Arrays.asList(mealTimesArray);

      //Int orderNumbersArray[] = orderNumberStringToArray(stringArr[1]);

    
      //Check if mealtime is entered correctly
      if (!list.contains(mealTime.toLowerCase())) {
        System.out.println(
          "\nPlease enter a valid meal time. (EX: Breakfast, Lunch or Dinner)"
        );
        return false;
      }
    //   //Check if any of the order numbers do not exist.
    //   if (
    //     !orderNumbersArray.every(function (e) {
    //       return e <= 4;
    //     })
    //   ) {
    //     console.log("\nOne of the items in your order does not exist\n");
    //     return false;
    //   }
    //   return [meanTime, orderNumbersArray];
    return true;
    }
    
    public static void main(String[] args) { 
      Scanner cin = new Scanner(System.in);
        Boolean valid = false;
        do {
         System.out.println( "\nPlease enter a valid meal time. (EX: Breakfast, Lunch or Dinner)");
         String userInput = cin.next();
         valid = validateInput(userInput);
        } while (valid != true);
        System.out.println("correct!\n");
    }

 }

