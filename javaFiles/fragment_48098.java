public static void main(String args[]) throws IOException {
    child c1 = new child();
    parent p1 = c1;

    System.out.println("p1.a is " + p1.a);
    System.out.println("c1.a is " + c1.a);
    System.out.println("p1 == c1 is " + (p1 == c1));
}