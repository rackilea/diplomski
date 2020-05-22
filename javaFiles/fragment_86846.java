public class IconRadioButtonEval {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        // Use some arbitrary working URL to an icon
        URL url =
                new URL(
                        "http://mikeo.co.uk/demo/sqlspatial/Images/RSS_Icon.png");
        Icon icon = new ImageIcon(url);
        JRadioButton button = new JRadioButton(icon);
        panel.add(new JLabel("RadioButton with icon:"));
        panel.add(button);
        panel.add(new JLabel("RadioButtonMenuItem with icon:"));
        panel.add(new JRadioButtonMenuItem(icon));

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}