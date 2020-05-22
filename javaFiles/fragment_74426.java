// ...
frame.setSize(400, 400);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new FlowLayout());             // <-- you need this

final JLabel label = new JLabel();
label.setPreferredSize(new Dimension(80, 40)); // <-- also this
label.setIcon(new ImageIcon(bi));
label.setText("Hello World");
// ...