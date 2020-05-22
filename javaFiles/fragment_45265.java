JPanel buttonPanel = new JPanel( new GridLayout(...) );
buttonPanel.add(...);

JPanel leftPanel = new JPanel( new GridBagLayout() );
leftPanel.add(buttonPanel, new GridBagConstraints());

JPanel centerPanel = new JPanel();
center.setBackground( Color.YELLOW );

frame.add(leftPanel, BorderLayout.PAGE_START);
frame.add(centerPanel, BorderLayout.CENTER);