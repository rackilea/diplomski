public static void main(String[] args) {
    A testA = new A();
    testA.text = "Test";

    B testB = testA;

    System.out.println(((A)testB).text); // This prints "Test"
}