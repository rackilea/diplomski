buttonPanel = new JPanel();
    button = new JButton("Display Color");
    button.addActionListener(new ButtonListener()); // Add event handler
    button.setFont(font);

    buttonPanel.add(button);