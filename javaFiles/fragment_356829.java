interface CoreConstant {
    int intValue();
}

enum CoreConstants implements CoreConstant {
    CORE_CONSTANT_1(1),
    CORE_CONSTANT_2(2);
    private final int intValue;
    public CoreConstants(int intValue) { this.intValue = intValue; }
    public int intValue() { return intValue; }
}

interface CustomerConstant extends CoreConstant {}

enum CustomerConstants implements CustomerConstant {
    CUSTOMER_CONSTANT_1(1000);
    private final int intValue;
    public CustomerConstants(int intValue) { this.intValue = intValue; }
    public int intValue() { return intValue; }    
}