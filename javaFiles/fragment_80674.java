class DimPanel extends JPanel implements ActionListener {
    private JSlider brightness;

    public DimPanel() {
        super(new GridBagLayout());

        ...
        brightness = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        add(brightness);
    }

    @Override
    public Dimension getMaximumSize() {
        Dimension max = super.getMaximumSize();
        max.height = getPreferredSize().height;
        return max;
    }

    public int getBrightness() {
        return brightness.getValue();
    }
}