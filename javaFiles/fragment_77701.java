SpringLayout springLayout = new SpringLayout();
Container cont = getContentPane();
cont.setLayout(springLayout);

JLabel label = new JLabel("New label");
springLayout.putConstraint(SpringLayout.WEST, label, 20, SpringLayout.WEST, cont);
springLayout.putConstraint(SpringLayout.SOUTH, label, -10, SpringLayout.SOUTH, cont);
cont.add(lblNewLabel);