public class SingleActionListener implements ActionListener {
    public void initializeButtons() {
        JButton[] buttons = new JButton[4];
        String[] buttonNames = new String[] {"button1", "button2", "button3", "button4"};

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton(buttonNames[i]);
        }
    }

    public void addActionListenersToButtons() {
        for (int i = 0; i < 4; i++) {
            buttons[i].addActionListener(this);
        }
    }

    public void actionPerformedd(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttons[0]) {
            //Do required tasks.
        }

        if (actionEvent.getSource() == buttons[1]) {
            //Do required tasks.
        }

        if (actionEvent.getSource() == buttons[2]) {
            //Do required tasks.
        }

        if (actionEvent.getSource() == buttons[3]) {
            //Do required tasks.
        }
    }
}