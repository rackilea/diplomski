public class HelloWorld {
    public int int_value = 42;

    public HelloWorld() { }

    public static void main( String args[] ) {
        HelloWorld hw = new HelloWorld();
        System.out.println( "Hello, " + hw.int_value );
    }  
}