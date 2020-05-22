public abstract class A {
    public int getNewNo() {
        int newNo = getNo() + 2;
        return newNo;
    }

    abstract int getNo();
}