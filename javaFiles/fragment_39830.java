public class WrapperPane extends JPanel {

    public WrapperPane() {
        setLayout(new FlowLayout());
        add(makePanel(Color.RED));
        add(makePanel(Color.GREEN));
        // This is just for demonstration purposes
        setBorder(new LineBorder(Color.DARK_GRAY));
    }

    protected JPanel makePanel(Color background) {
        JPanel panel = new JPanel();
        panel.setBackground(background);
        panel.setPreferredSize(new Dimension(100, 100));
        return panel;
    }

}