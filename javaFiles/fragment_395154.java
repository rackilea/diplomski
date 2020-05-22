JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = f.getContentPane();

    JPanel panel = new JPanel();
    panel.add(scrollPane);
    panel.setPreferredSize(new Dimension(50,40));
    contentPane.add(panel);