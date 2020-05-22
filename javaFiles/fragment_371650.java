JTextField field = new JTextField();
    field.setText(labelText);

    // this font has the symbol
    field.setFont(new Font("Courier New", Font.PLAIN, 12));
    panel.add(field);
    field = new JTextField();
    field.setText(labelText);

    // this font does not
    field.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
    panel.add(field);
    panel.add(field);