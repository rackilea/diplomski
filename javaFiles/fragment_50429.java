WritableValue<Double> writable = new WritableValue<Double>() {

    @Override
    public Double getValue() {
        return AnchorPane.getLeftAnchor(child);
    }

    @Override
    public void setValue(Double value) {
        AnchorPane.setLeftAnchor(child, value);
    }

};

// a starting value for the animation is important, since otherwise interpolation won't work
AnchorPane.setLeftAnchor(child, 0d);