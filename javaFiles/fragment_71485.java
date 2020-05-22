abstract class MyInt {

    private int myInt;

    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int i) {
        myInt = checkMyInt(i);
    }

    protected abstract int checkMyInt(int i);
}