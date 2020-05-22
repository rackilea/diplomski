CardLayout layout = new CardLayout();
 JFrame frame = new JFrame();
 frame.setLayout(layout);

 JPanel panel1 = new JPanel();
 JPanel panel2 = new JPanel();

 frame.add(panel1, "first");
 frame.add(panel2, "second");