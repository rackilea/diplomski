JButton newRoundButton= new JButton("Start another round");
newRoundButton.setPreferedSize(new Dimension(150, 50));
newRoundButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hi there for a new round");
        game.userTurn();
    }
});
endGamePanel.add(newRoundButton);