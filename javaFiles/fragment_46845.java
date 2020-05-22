JFrame frame = new JFrame();
frame.setSize(300,300);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JTable table = new JTable(5, 5);
table.setBackground(Color.GRAY);

frame.setLayout(new FlowLayout());
frame.add(table);