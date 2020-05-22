class LightPanel extends JPanel {
    private JPanel dimPanel;
    private JSlider dimmer;

    public LightPanel(int roomNum) {
        ...

        dimPanel = new JPanel(new GridBagLayout()) {
            @Override
            public Dimension getMaximumSize() {
                Dimension max = super.getMaximumSize();
                max.height = getPreferredSize().height;
                return max;
             }
        };
        ...

        dimmer = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        dimPanel.add(dimmer);

        ...
    }
}