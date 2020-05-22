public class MyException12 extends Exception {
    public String getCustomValue(){ return "boo"; };
}

public class MyException1 extends MyException12{
    public String getCustomValue() { return "foo"; };
}

public class MyException2 extends MyException12{
    // constructors, etc
    public String getCustomValue() { return "foo"; };
}