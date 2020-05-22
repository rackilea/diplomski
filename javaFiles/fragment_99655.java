for(int i = 0; i < numberPinButton; i++) {
    pinButton[i] = new JButton("" + i);
    pinButton[i].setActionCommand(String.valueOf(i));
    pinButton[i].addActionListener(this);
    panel.add(pinButton[i]);
}