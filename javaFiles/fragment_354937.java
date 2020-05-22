public class Test {
    public static void main(String[] args) {
        A myA = new A(1);
        B myB = new B(2);

        B anotherB = new B(3);

        myA.setMyB(anotherB);

        System.out.println("A = " + myA.getName());
        System.out.println("A's B = " + myA.getMyB().getName());

        System.out.println("B = " + myB.getName());
        System.out.println("B'a A = " + myB.getMyA().getName());
    }
}