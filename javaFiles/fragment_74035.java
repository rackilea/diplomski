public class Outer{

    public Outer() {
        new Runnable() {
            public void printit() {
                System.out.println( "Anonymous Inner" );
            }
            public void run() {
                printit(); // prints "Anonymous Inner"
                this.printit(); //prints "Anonymous Inner"

                // would not be possible to execute next line without this behavior
                Outer.this.printit(); //prints "Outer" 
            }
        };
    }

    public void printit() {
        System.out.println( "Outer" );
    }
}