enum Operation {
    DIVISION("/"), MULTIPLICATION("*"), SUBTRACTION("-"), 
    ADDITION("+"), CLEAR("C"), EQUALS("=");

    private String text;

    private Operation(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}