this.setLayout(new BorderLayout());
JPanel buttonPanel = new JPanel();
buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
JButton clickmeButton = new JButton("Click Me");
buttonPanel.add(clickmeButton);
this.add(buttonPanel,BorderLayout.SOUTH);