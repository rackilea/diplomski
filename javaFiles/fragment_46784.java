JPanel panel = new JPanel(new MigLayout());
panel.add(firstNameLabel);
panel.add(firstNameTextField);
panel.add(lastNameLabel,"gap unrelated");
panel.add(lastNameTextField,"wrap");
panel.add(addressLabel);
panel.add(addressTextField,"span, grow");