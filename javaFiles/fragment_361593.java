public class ThoseDays {

  public static void main(String[] args) {

  //Scanner implements AutoCloseable
  //https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
    try (Scanner obj = new Scanner(System.in)) { 
      System.out.print("Enter number between 0-6 : ");
      int startFromHere = obj.nextInt();

      System.out.print("Enter number to count position from " + startFromHere + " : ");
      int rotateFromHere = obj.nextInt();
      int absoluteNumber = startFromHere + rotateFromHere;
      System.out.println(absoluteNumber);
      int rotatedNumber = absoluteNumber % 7;
      System.out.println(rotatedNumber);
    }
  }
}