class AnotherClass {
    private int instanceVariable;
    private static int classVariable = 42;

    public int getInstanceVariable() {
        return instanceVariable;
    }

    public static int getClassVariable() {
        return classVariable;
    }

    public AnotherClass(int i) {
        instanceVariable = i;
    }
}