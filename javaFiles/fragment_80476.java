final JSlider sliderFilter1;
final JSlider sliderFilter2;
final JCheckBox chckbxConnectSlider;

sliderFilter1 = new JSlider(-5, 5, 0);
sliderFilter1.setPaintTicks(true);
sliderFilter1.setMajorTickSpacing(1);
sliderFilter1.setBounds(10, 459, 200, 32);
add(sliderFilter1);

sliderFilter2 = new JSlider(-5, 5, 0);
sliderFilter2.setMajorTickSpacing(1);
sliderFilter2.setPaintTicks(true);
sliderFilter2.setBounds(10, 503, 200, 32);
add(sliderFilter2);

chckbxConnectSlider = new JCheckBox("Connect Slider");
chckbxConnectSlider.setBounds(6, 547, 131, 23);
add(chckbxConnectSlider);

sliderFilter1.addChangeListener(new ChangeListener() {
    private int lastValue = 0;
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (lastValue != ((int) source.getValue()) && chckbxConnectSlider.isSelected()) {
            lastValue = (int) source.getValue();
            sliderFilter2.setValue(-((int) source.getValue()));
        }
    }
});
sliderFilter2.addChangeListener(new ChangeListener() {
    private int lastValue = 0;
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (lastValue != ((int) source.getValue()) && chckbxConnectSlider.isSelected()) {
            lastValue = (int) source.getValue();
            sliderFilter1.setValue(-((int) source.getValue()));
        }
    }
});