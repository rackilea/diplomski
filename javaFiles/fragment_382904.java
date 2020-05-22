public class X {

  public static String findMin(String[] numbers, int counter) {
    int count = 0;
    String elements = "";
    for (String tempElement: numbers) {
      int tempCount = 0;
      for (int n = 0; n < numbers.length; n++) {
        if (numbers[n].equals(tempElement)) {
          tempCount++;
          if (tempCount > counter) {
            count = 0;
            break;
          }
          if (tempCount > count) {
            elements = tempElement;
            //  System.out.println(elements);
            count = tempCount;
          }
        }
      }
      if (count == counter) {
        return elements;
      }
    }
    if (count < counter) {
      return "";
    }
    return elements;
  }

  public static void main(String[] args) {
    String[] numbers = "756655874075297346".split("");
    String elements = "";
    int count = 0;
    for (String tempElement: numbers) {
      int tempCount = 0;
      for (int n = 0; n < numbers.length; n++) {
        if (numbers[n].equals(tempElement)) {
          tempCount++;
          if (tempCount > count) {
            elements = tempElement;
            //  System.out.println(elements);
            count = tempCount;
          }
        }
      }
    }
    String x = "";
    int c = 2;
    do {
      x = findMin(numbers, c++);
    } while (x == "");

    System.out.println("Frequent number is: " + elements + " It appeared " + count + " times");

    System.out.println("Min Frequent number is: " + x + " It appeared " + (c - 1) + " times");
  }
}