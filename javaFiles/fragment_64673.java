newGameBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("New Game");
        controller.newGame();
    }
});