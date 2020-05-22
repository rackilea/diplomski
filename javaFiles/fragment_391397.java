public class AdjustedLabel extends JPanel {

    public AdjustedLabel(String leftText, String rightText) {
        JLabel leftLabel = new JLabel(leftText, SwingConstants.LEFT);
        JLabel rightLabel = new JLabel(rightText, SwingConstants.RIGHT);
        setLayout(new BorderLayout());
        add(leftLabel, BorderLayout.WEST);
        add(rightLabel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("label testing");
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(new AdjustedLabel("VarA:", "123.4"));
        panel.add(new AdjustedLabel("VarB:", "Green"));
        panel.add(new AdjustedLabel("DateMax:", "12/03/13"));
        frame.setContentPane(panel);
        frame.setSize(200, 100);
        frame.setVisible(true);
    }
}