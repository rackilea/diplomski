enum MyEnum 
{   FOO("Foo"), 
    BAR_EXAMPLE("Bar Example"); 
    private String displayValue;

    MyEnum(String displayValue)
    {
        this.displayValue = displayValue;
    }

    public String getDisplay()
    {
        return displayValue;
    }
}