public class Example {
    static{
        num = 3; // assignment OK without qualifying the name
        System.out.print(Example.num); // name must be qualified to access value
    }
    public static int num;
}