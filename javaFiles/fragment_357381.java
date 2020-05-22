public static void main(String[] args) throws IOException {

    JFrame frame = new JFrame("Test");
    frame.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(1, 1, 1, 1);

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 0;
    gbc.gridx = 0;

    frame.add(new JLabel("Remote IP : "), gbc);
    frame.add(new JLabel("User Name : "), gbc);
    frame.add(new JLabel("Remote Password : "), gbc);
    frame.add(new JLabel("Remote Path : "), gbc);
    frame.add(new JLabel("Device or Simulator : "), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;

    frame.add(new JTextField("Remote IP"), gbc);
    frame.add(new JTextField("User Name"), gbc);
    frame.add(new JTextField("Remote Password"), gbc);
    frame.add(new JTextField("Remote Path"), gbc);
    frame.add(new JTextField("Device or Simulator"), gbc);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}