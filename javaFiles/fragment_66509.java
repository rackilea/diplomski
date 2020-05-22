final double max = 100;
TextField text = new TextField();
DoubleBinding percentage = new DoubleBinding() {
    {
        super.bind(text.textProperty());
    }
    @Override
    protected double computeValue() {
        return text.getText().length() / max;
    }
};