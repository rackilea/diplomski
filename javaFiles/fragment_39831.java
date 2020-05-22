JTextField text = new JTextField();
JFrame frame = new JFrame();
frame.setLayout(new BorderLayout());
JPanel panel = new JPanel();
panel.setLayout(new GridLayout(5, 4));

for (int i = 0; i < 20; i++) {
    panel.add(new WrapperPane());
}

frame.add(text, BorderLayout.NORTH);
frame.add(panel, BorderLayout.CENTER);
// Don't do this, just let the content make it's own
// calculations
//frame.setPreferredSize(new Dimension(1280, 700));
frame.pack();
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);