JFrame window = new JFrame();

JPanel contentPanel = new JPanel();
contentPanel.setLayout(new FlowLayout());
contentPanel.add(new JLabel("Label 1"));
contentPanel.add(new JLabel("Label 2"));
contentPanel.add(new JLabel("Label 3"));

window.add(new JTextField(), BorderLayout.NORTH);
window.add(contentPanel,     BorderLayout.CENTER);

window.setSize(new Dimension(300, 150));
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setVisible(true);