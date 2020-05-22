public class Example {
    static{
        System.out.println(Example.num); // uses default value
        num = 3;                         // assignment OK
        System.out.println(Example.num); // assigned value (3) is visible
    }

    public static int num = 1;           // initialization to 1 occurs

    static{
        System.out.print(Example.num);   // initialized value (1) is visible 
    }
}