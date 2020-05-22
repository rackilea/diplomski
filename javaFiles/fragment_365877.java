public CalButton() {
    // TODO Auto-generated constructor stub
    buttons = new JButton[buttonNames.length];
    //buttonPanel = new JPanel();
    //buttonPanel.setLayout(new GridLayout(4, 4, 3, 3));
    setLayout(new GridLayout(4, 4, 3, 3));

    for(int i=0; i<buttonNames.length; i++){
        buttons[i] = new JButton(buttonNames[i]);
        //buttonPanel.add(buttons[i]);
        add(buttons[i]);
    }
}