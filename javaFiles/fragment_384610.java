// A top-level Java class mimicking static class behavior
public final class MyStaticClass {
    private MyStaticClass () { // private constructor
        myStaticMember = 1;
    }
    private static int myStaticMember;
    public static void setMyStaticMember(int val) {
        myStaticMember = val;
    }
    public static int getMyStaticMember() {
        return myStaticMember;
    }
    public static int squareMyStaticMember() {
        return myStaticMember * myStaticMember;
    }
}

public class TestStaticClass {
     public static void main(String []args){
        MyStaticClass.setMyStaticMember(5);
        System.out.println("Static value: " + MyStaticClass.getMyStaticMember());
        System.out.println("Value squared: " + MyStaticClass.squareMyStaticMember());
        // MyStaticClass x = new MyStaticClass(); // results in compile time error
     }
}