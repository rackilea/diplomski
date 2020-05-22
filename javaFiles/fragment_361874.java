public class SliderPane extends JPanel {

    private JSlider diameterJSlider;
    private Circle1 myPanel;

    public SliderPane() {

        setLayout(new BorderLayout());

        myPanel = new Circle1();

        diameterJSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 300, 10);
        diameterJSlider.setMajorTickSpacing(10);
        diameterJSlider.setPaintTicks(true);
        diameterJSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                myPanel.setDiameter(diameterJSlider.getValue());
            }
        }
        );
        add(diameterJSlider, BorderLayout.NORTH);
        add(myPanel, BorderLayout.CENTER);
    }
}