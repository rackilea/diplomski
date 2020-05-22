public class MyEnum {

    public static final MyEnum YES = new MyEnum(true, 1);
    public static final MyEnum NO = new MyEnum(false, 0);

    private boolean boolState;
    private int intState;

    MyEnum(boolean boolState, int intState) {
        this.boolState = boolState;
        this.intState = intState;
    }

    public boolean getBoolState() {
        return boolState;
    }

    public int getIntState() {
        return intState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyEnum myEnum = (MyEnum) o;

        return boolState == myEnum.boolState && intState == myEnum.intState;
    }

}