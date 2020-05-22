JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    JPanel tablePanel = new JPanel();
    JScrollPane jsp = new JScrollPane(new JTable());
    tablePanel.add(jsp);
    mainPanel.add(jsp, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1, 2));
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    buttonPanel.add(button1);
    buttonPanel.add(button2);
    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    this.add(mainPanel);