public class MyReturnValues {
    private int integer1;
    private int integer2;
    private String myString;
    //etc

    public MyReturnValues() {
    }

    public MyReturnValues(int integer1, int integer2, String myString) {
        this.integer1 = integer1;
        this.integer2 = integer2;
        this.myString = myString;
    }

    public int getInteger1() {
        return integer1;
    }

    public void setInteger1(int integer1) {
        this.integer1 = integer1;
    }

    public int getInteger2() {
        return integer2;
    }

    public void setInteger2(int integer2) {
        this.integer2 = integer2;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }
}