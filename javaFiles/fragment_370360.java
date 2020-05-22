JLabel addHomeLabel = new JLabel();
//add label to gui...
addHome.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
        //Execute when button is pressed
        addHomeCount++;
        addHomeLabel.setText("Button pressed " + addHomeCount);

    }
});