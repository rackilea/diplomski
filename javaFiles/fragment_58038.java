public  JPanel setupButtons(User u){

    JPanel forButtons = new JPanel();
    ButtonGroup group = new ButtonGroup();
    radioButtons = new JRadioButton[u.projectSize()]; // <- This is new

    for(int i = 0; i != u.projectSize(); i++){
        radioButtons[i] = new JRadioButton(u.getProject(i).getName());
        forButtons.add(radioButtons[i]);
        group.add(radioButtons[i]);

        radioButtons[i].addActionListener(this);
        radioButtons[i].setEnabled(true);
    }
}