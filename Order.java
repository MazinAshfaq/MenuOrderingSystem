import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
  private String main;

  public String getMain() {
    return main;
  }

  public void setMain(String main) {
    this.main = main;
  }

  private String side;

  public String getSide() {
    return side;
  }

  public void setSide(String side) {
    this.side = side;
  }

  public Order(String main, String side) {
    this.main = main;
    this.side = side;
  }

  // Check if main and side are included
  public Boolean checkMainAndSideMissing(int[] orderNumbers) {
    Boolean mainMissing = false;
    Boolean sideMissing = false;
    int main = 1;
    int side = 2;

    if (!contains(orderNumbers, main)) {
      mainMissing = true;
    }

    if (!contains(orderNumbers, side)) {
      sideMissing = true;
    }

    if (!mainMissing && !sideMissing) {
      return false;
    } else if (mainMissing && !sideMissing) {
      System.out.println("\nUnable to process: Main is missing");
    } else if (mainMissing && sideMissing) {
      System.out.println("\nUnable to process: Main is missing, side is missing");
    } else {
      System.out.println("\nUnable to process: Side is missing");
    }

    return true;
  }

  public boolean hasDrink(int[] orderNumbers) {
    int drink = 3;
    if (!contains(orderNumbers, drink)) {
      return false;
    }
    return true;
  }

  public int countMultipleOrders(int[] orderNumbers, int order) {
    int count = 0;
    for (int i = 0; i < orderNumbers.length; i++) {
      if (orderNumbers[i] == order) {
        count++;
      }
    }
    return count;
  }

  public static boolean contains(final int[] arr, final int key) {
    return Arrays.stream(arr).anyMatch(i -> i == key);
  }

}
