private class MyClass() {

    public String innerString;

    public MyClass(String s) {
        innerString = s;
    }

    @Override
    public String toString() {
        return innerString.toString();
    }
}