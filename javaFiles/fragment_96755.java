public enum Tax {
    NONE(0), SALES(10), IMPORT(5);

    private final int value;
    private Tax(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

...

public int getTaxValue() {
    Tax tax = Tax.NONE; // Or whatever
    return tax.getValue();
}