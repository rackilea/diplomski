private class AnswerCell extends Label {

    int a;
    int b;
    int value;

    public AnswerCell( int a, int b) {
        this.a = a;
        this.b = b;
        this.value = a * b;
        setText( a + " * " + b);
    }

    public boolean matches( int matchValue) {
        return value == matchValue;
    }

    public void highlight() {
        getStyleClass().add( "gridAnswer");
    }

    public void unhighlight() {
        getStyleClass().remove( "gridAnswer");
    }
}