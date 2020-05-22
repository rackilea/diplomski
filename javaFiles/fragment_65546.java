int player = 0;
String [] symbol = {"X", "O"};

for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 3; j++) {
        board[i][j].setOnAction(action -> {
            plansza[i][j].setText(symbol[player]);

            checkIfPlayerWon();

            player = (player + 1) % 2;
        });
    }
}