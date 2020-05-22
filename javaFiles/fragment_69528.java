ActionListener buttonActionListener = new ButtonActionListener();
for (int i = 0; i<buttons.length; i++) {
    ...
    buttons[i] = new JButton(...);

    buttons[i].addActionListener(buttonActionListener);
}