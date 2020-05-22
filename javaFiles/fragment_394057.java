JButton startButton = new JButton("Start");
startButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        initTimer();
    }
});