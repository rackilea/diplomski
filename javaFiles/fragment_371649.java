public static void main(String[] args) {
    String labelText = "\u25C4 \u25BA";
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    JLabel label = new JLabel();
    label.setText(labelText);
    panel.add(label);
    frame.pack();
    frame.setVisible(true);
}