class MvcView {
    private JPanel mainPanel = new JPanel();
    private JSlider speedSlider = new JSlider(0, MvcModel.MAX_SPEED);
    private JSlider batterySlider = new JSlider(0, 100);
    private JProgressBar speedBar = new JProgressBar(0, MvcModel.MAX_SPEED);
    private JProgressBar batteryPercentBar = new JProgressBar(0, 100);

    public MvcView() {
        speedSlider.setMajorTickSpacing(5);
        speedSlider.setMinorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setPaintTrack(true);

        batterySlider.setMajorTickSpacing(20);
        batterySlider.setMinorTickSpacing(5);
        batterySlider.setPaintTicks(true);
        batterySlider.setPaintLabels(true);
        batterySlider.setPaintTrack(true);

        speedBar.setStringPainted(true);
        batteryPercentBar.setStringPainted(true);

        JPanel inputPanel = new JPanel(new GridLayout(0, 1));
        inputPanel.add(createTitledPanel("Speed", speedSlider));
        inputPanel.add(createTitledPanel("Battery %", batterySlider));

        JPanel displayPanel = new JPanel(new GridLayout(0, 1));
        displayPanel.add(createTitledPanel("Speed", speedBar));
        displayPanel.add(createTitledPanel("Battery %", batteryPercentBar));

        mainPanel.setLayout(new GridLayout(1, 0));
        mainPanel.add(createTitledPanel("Input", inputPanel));
        mainPanel.add(createTitledPanel("Display", displayPanel));
    }

    private JComponent createTitledPanel(String title, JComponent component) {
        JPanel titledPanel = new JPanel(new BorderLayout());
        titledPanel.setBorder(BorderFactory.createTitledBorder(title));
        titledPanel.add(component);
        return titledPanel;
    }


    public JComponent getMainDisplay() {
        return mainPanel;
    }


    public void setSpeed(float speed) {
        speedBar.setValue((int) speed);
    }


    public void setBatteryPercent(int batteryPercent) {
        batteryPercentBar.setValue(batteryPercent);
    }


    public JSlider getSpeedSlider() {
        return speedSlider;
    }

    public JSlider getBatterySlider() {
        return batterySlider;
    }

}