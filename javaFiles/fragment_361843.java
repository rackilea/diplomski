class AnotherClass {

    public static void main (String[] args) throws Exception {

        SomeClass p = new SomeClass();
        Field i =p.getClass().getDeclaredField("i");
        i.setAccessible(true);
        i.set(p, 5);
        System.out.println("p.i = " + p.i); // prints 5
    }
}