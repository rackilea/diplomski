JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = (JPanel) frame.getContentPane();
    panel.setLayout(null);

    JLabel label = new JLabel("Java");
    panel.add(label);
    Dimension size = label.getPreferredSize();
    label.setBounds(90, 100, size.width, size.height);

    frame.setSize(300, 200);
    frame.setVisible(true);