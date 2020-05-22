public class BaseClass {
    protected String strValue;

    public BaseClass () {
        strValue = "";
    }

    public BaseClass (String str) {
        strValue = str;
    }
}

public class SubClass extends BaseClass {
    private int intValue;

    SubClass (String str, int i) {
        super (str);
        intValue = i;

        // note that since strValue is protected, SubClass can access directly
        System.out.println ("strValue = " + strValue);
    }
}