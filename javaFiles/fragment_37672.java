// button whose maxWidth is always prefWidth + 200
Button button = new Button() {
    @Override
    protected double computeMaxWidth(double height)
    {
        return this.prefWidth(height) + 200.0;
    }
};