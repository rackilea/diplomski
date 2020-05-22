public enum MyEnum1 implements IntSupplier {

    ConstantA(1),
    ConstantB(2),
    ConstantC(3);

    private final int number;

    private MyEnum1(int number) { this.number = number; }
    public int getAsInt() { return number; }
}