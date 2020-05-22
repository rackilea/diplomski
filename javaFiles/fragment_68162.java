public final class JavaApplication6 {
    String server;

    //public constructor
    public  JavaApplication6(String s) {
        server=s;
    }
    //here is where the execution begins.
    public static void main(String[] args) throws IOException {
    //create a object of your class 

        JavaApplication6 app = new JavaApplication6(/*here is where you pass the arguments to the constructor*/ args[0]);


    }

}