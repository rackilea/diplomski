this.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (someVar == someVal) {
            showSomeScreen();
        }
        else {
            showSomeOtherScreen();
        }
    }
});