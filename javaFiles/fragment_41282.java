public class TimeTester {

  public static void main(String[] args) {

    // Test the default constructor
    Time time = new Time();

    System.out.println("time = " + time);
    System.out.println("time.toHour() " + time.toHour());
    // etc..

    // Test with a supplied value
    Time time2 = new Time(12033312L);
    System.out.println("time2 = " + time2); 
    // etc..
   }
}