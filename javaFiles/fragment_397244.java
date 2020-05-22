public static void main(String[] args) {

    final JFrame frame = new JFrame("Test");

    frame.add(new JLabel("Testing (no tooltip here)"), BorderLayout.NORTH);

    final JPanel panel = new JPanel(new GridLayout(2, 1));
    panel.setBackground(Color.RED);

    panel.add(new JLabel("Hello"));
    panel.add(new JTextField("World!"));

    setToolTipRecursively(panel, "Hello World!");

    frame.add(panel, BorderLayout.CENTER);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}