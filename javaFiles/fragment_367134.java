class B extends A {
    private int size = 1; // default set of size

    public int getSize() {
        return size;
    }

    public void grow(int factor) {
        size = size * factor;
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getSize()); //Prints 1
    }
}