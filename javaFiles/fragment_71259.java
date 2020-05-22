interface Player {
    Move decide(List<Move> legalMoves);
}

class ChessGame {

    ABChess game;

    Player player1;
    Player player2;
    UIInterface ui;

    ChessGame(Player player1, Player player2, UIInterface ui) {
        this.player1 = player1;
        this.player2 = player2;
        this.ui = ui;

        game = ...
    }

    public void simulate() {

        // ... initial ui ...

        boolean player1Turn = true;

        do {
            Move move = null;

            if (player1Turn) {
                move = player1.decide(game.possibleMoves());
            } else {
                move = player2.decide(game.possibleMoves());
            }

            game.makeMove(move);
            // ... update ui ...

            player1Turn = !player1Turn;

        // check if somebody has won ...
        } while (game.isRunning());

        // ... update ui with the game result ...
    }
}