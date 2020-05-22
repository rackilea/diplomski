public abstract class Singer {
    public static void sing() {
        System.out.println("Singing");
    }
}

public class Soprano extends Singer {
    public static void sing() {
        System.out.println("Singing in the range of C4-A5");
    }
}

public class MyDriver {

    public static void main(String[] argv) {
        Singer  mySoprano1 = new Soprano();
        Soprano mySoprano2 = new Soprano();
        mySoprano1.sing();
        mySoprano2.sing();
    }

}