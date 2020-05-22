@Override
protected void updateItem(Integer item, boolean empty) {
    super.updateItem(item, empty);

    if (item == null || empty) {
        setText(null);
        setStyle(""); // set cell style
    } else {
        if (checkCondition) {
            setTextFill(Color.CHOCOLATE);
            setStyle("-fx-background-color: red;");// set your css style here if condition is true
        } else {
            setTextFill(Color.BLACK);
            setStyle(""); // reset the style if condition is false.
        }
    }
}