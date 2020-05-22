Action actionA = new AbstractAction("Synch A to clock") {

    @Override
    public void actionPerformed(ActionEvent e) {
        // do stuff A
    }
};
JRadioButtonMenuItem buttonA = new JRadioButtonMenuItem(actionA);
Action actionB = new AbstractAction("Synch B to clock") {

    @Override
    public void actionPerformed(ActionEvent e) {
        // do stuff B
    }
};
JRadioButtonMenuItem buttonB = new JRadioButtonItem(actionB);
ButtonGroup ... // add buttons to group
JPopupMenu ... // add buttons to menu