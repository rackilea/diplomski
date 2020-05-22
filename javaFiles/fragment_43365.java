interface Interface {
    default void interface1() {
        System.out.println("interface1");
    }

    void interface2();
}

class Clazz implements Interface {
    @Override
    public void interface2() {
        System.out.println("interface2");
    }
}