enum BadEnum {
    INSTANCE;

    private int foo;

    private int getFoo() {
        return foo;
    }

    public int setFoo(int foo) {
        this.foo = foo;
    }
}

class Test {
    public static void main(String[] args) {
        BadEnum.INSTANCE.setFoo(10);
        System.out.println(BadEnum.INSTANCE.getFoo()); // Prints 10
    }
}