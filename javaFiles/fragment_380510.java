slider.addChangeListener(new ChangeListener() {

    @Override
    public void stateChanged(ChangeEvent e) {
        // only output when value is set (when the mouse is released from the knob)
        // remove this if statement if you would like output whenever the knob is moved
        if(!slider.getValueIsAdjusting()) {
            System.out.println(slider.getValue());
        }
    }

});