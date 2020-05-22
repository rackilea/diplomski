JButton b1 = new JButton("button1");
    String[] columnNames = { "kolumna 1", "kol 2", "kol3" };
    JTable itemTable = new JTable(new DefaultTableModel(columnNames, 10));
    JScrollPane scrollPane = new JScrollPane(itemTable);

    JButton b2 = new JButton("button2");

    b1.setAlignmentX(Component.LEFT_ALIGNMENT);
    scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
    b2.setAlignmentX(Component.LEFT_ALIGNMENT);

    JPanel panel = new JPanel();
    BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(layout);

    panel.add(b1);
    panel.add(scrollPane);
    panel.add(b2);