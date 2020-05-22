int iterator = 0;
for (JButton curButton : view.getButtons()) {

    curButton.addActionListener(new ButtonListener(iterator%5 + 1, iterator/5 + 1));

    iterator++; 
}