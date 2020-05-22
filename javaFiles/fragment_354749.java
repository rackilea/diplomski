public static void main(String[] args) {
    AbstractObject o1 = new Object1();
    o1 = new Object1();
    o1 = new Object2();
    o1 = new Object11();
    o1 = new Object11();
    o1 = new Object12();

    AbstractObject.getCounters().forEach((k, v) -> System.out.println(k + " ==> " + v));
}