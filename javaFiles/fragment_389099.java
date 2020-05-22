JSlider slider = new JSlider(0, 60); //minimum=0 so major ticks appear on multiples of 10
slider.setValue(20);
slider.setMajorTickSpacing(10);
slider.setMinorTickSpacing(1);
slider.setLabelTable(slider.createStandardLabels(10, 10));
slider.setPaintLabels(true);
slider.setPaintTicks(true);
slider.setSnapToTicks(true);

//If the slider is set to 0, reset it to 1
slider.addChangeListener(new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
        if (((JSlider) e.getSource()).getValue() == 0)
            ((JSlider) e.getSource()).setValue(1);
    }
});