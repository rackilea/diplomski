private class MyClass {

    private static int count = 0;

    public MyClass() {
        count = 0; //Bad line
    }

    public void incrementCount() {
        count++;
    }

}