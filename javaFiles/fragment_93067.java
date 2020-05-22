class A {
    private int value;

    @Override
    public String toString() {
        return "Value of my private field: " + value;
    }
}

class MutableA {
    public A a;
    private Field value;

    public MutableA(A a) {
        this.a = a;
        try {
            this.value = A.class.getDeclaredField("value");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        this.value.setAccessible(true);
    }

    void setValue(int value) {
        try {
            this.value.set(a, value);
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}