JTable table = new JTable(data, cols);
    JTextField jtf = new JTextField(20);
    JLabel label = new JLabel("This is a text field");
    JPanel panel = new JPanel();
    panel.add(label);
    panel.add(jtf);

    JFrame frame = new JFrame();
    frame.add(panel, BorderLayout.SOUTH);                     <----
    frame.add(new JScrollPane(table), BorderLayout.CENTER);   <----