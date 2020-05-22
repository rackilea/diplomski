public void turnMechanism() {
    final TurnBasedGame game = new TurnBasedGame();

    for (final User user : gf.getUsers()) {
        game.addPlayer(new Player(user));
    }

    gameStopButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            final Player currentPlayer = game.getCurrentPlayer();
            currentPlayer.setAnswer(createAnswerSet());
            game.endPlayerTurn();

            switch (game.getCurrentState()) {
                 case RUNNING:
                     //next player
                     showCurrentPlayerInfo(game);
                     break;
                 case ENDED:
                     //show your resutls here
                     showResults(game);
                     break;
            }
        }
    });
    game.start();
    showCurrentPlayerInfo(game);

    //not sure what this does
    new ResultsFrame(gf);
    dispose();
}

private void showCurrentPlayerInfo(TurnBasedGame p_game) {
    JOptionPane.showMessageDialog(null, p_game.getCurrentPlayer().getUser().getUserName() + 's turn);
}

private void showResults(TurnBasedGame p_game) {
    for (Player player : p_game.getPlayers()) {
        final AnswerSet answer = player.getAnswer();
        //do whatever you want with the answer
    }
}