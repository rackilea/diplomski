public interface InterfaceWithMethods {
    public default void doSomething() {
        doSomethingCommon();
    }

    public default void doSomethingElse() {
        doSomethingCommon();
    }

    public void actuallyDoSomething();

    private void doSomethingCommon() {
        System.out.println("Do something first.");
        actuallyDoSomething();
    }
}