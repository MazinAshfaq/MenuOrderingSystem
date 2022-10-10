// import Breakfast;
// import Lunch;
// import Dinner;

import java.util.Scanner;

import java.util.Arrays;
import java.util.List;
public class Order {
   private String main;
   private String side;
   private int[] orderNumbers;

   public Order(String main, String side) {
      this.main = main;
      this.side = side;
    }

    public static int[] parseOrderNumbers(String[] ordersStringArray){

        int[] orderNumbersIntArray = Arrays.stream(ordersStringArray).mapToInt(Integer::parseInt).toArray();
        return orderNumbersIntArray;
    }

    
    public static Boolean validateInput(String mealTime, int[] orderNumbersIntArray) {
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
    return true;
    }
    
    public static void main(String[] args) { 

      Scanner cin = new Scanner(System.in);
        Boolean valid = false;
        String mealTime;
        int[] orderNumbers;
        do {
         System.out.println("Please enter the meal followed by ids of food seperated with commas from its menu! (EX: Breakfast 1,2,3)");
         
         //Grab and save user input
         String userInput = cin.nextLine();
         String stringArr[] = userInput.split(" ");

         mealTime = stringArr[0];
         //Convert string of order numbers to int array
         orderNumbers = parseOrderNumbers(stringArr[1].split(","););

         valid = validateInput(mealTime, orderNumbers);

        } while (valid != true);

        if(valid){
            switch (mealTime) {
                case mealTime == "breakfast":
                  order = new Breakfast(orderNumbersArray);
                  break;
                case mealTime == "lunch":
                  order = new Lunch(orderNumbersArray);
                  break;
                case mealTime == "dinner":
                  order = new Dinner(orderNumbersArray);
                  break;
              }
            
        }

    }

 }

