abstract class A {

    public int size() {
        return this.getSize();
    }

    abstract public int getSize();

    // abstract method
    abstract void grow(int f);

}