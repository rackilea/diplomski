for (int i = 0; i < run.buttons.size(); i++) {
        numPad[i] = new JButton();
        numPad[i].setText(run.buttons.get(i));
        // You don't "have" to do this, as the action command defaults
        // to the text of the button, but this is away to provide some
        // kind of identifier to the action which might be
        // different from the text
        numPad[i].setActionCommand(run.buttons.get(i))
        numPad[i].addActionListener(new ButtonActionListener());
        panel1.add(numPad[i]);
}