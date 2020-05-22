public class Tester {

{
    System.out.println("In some random block");
}

static {
    System.out.println("In static block");
}

public Tester() {
    System.out.println("Constructor");
}


public static void main(String args[]) {
    Tester t = new Tester();
}


}