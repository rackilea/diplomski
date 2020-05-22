public enum Constants {
    ZERO("Zero",0),
    TWO("Two",2);

    final private String label;
    final private int value;

    Constants(String label, int value) {
        this.label = label;
        this.value= value;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}