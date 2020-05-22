import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoardGUI extends Application {

    private final static int BOARD_SIZE = 15;

    private final Tile[][] tileBoard = new Tile[BOARD_SIZE][BOARD_SIZE];

    private final Pane root = new Pane();

    private Parent createContent(Game game) {
        root.setPrefSize(755, 755);

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Tile tile = new Tile(i, j);
                tile.setTranslateX(j * 50);
                tile.setTranslateY(i * 50);

                final int row = i, col = j;
                tile.setOnMousePressed(e -> {
                    //the click causes a move
                    //game.playerMakeMove(game, row, col); //no need to  pass a reference of Game to Game
                    game.playerMakeMove(row, col); //no need to  pass a reference of Game to Game
                });

                root.getChildren().add(tile);
                tileBoard[i][j] = tile;
            }
        }
        return root;
    }

    @Override
    public void start(Stage primaryStage) {

        //there is no need to get a new instance of BoardGUI from Game.
        //Game game = new Game();
        //Scene scene = new Scene (game.gui.createContent(game));

        //instead:
        Game game = new Game(this);
        Scene scene = new Scene (createContent(game));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gomoku");
        primaryStage.show();

        //the player should make a move  (click) and it should trigger the next move
    }

    //method moved from Tile
    void makeMove(Board board, int player, int row, int col) {

        if (board.isMoveAvailable(row, col)) {
            tileBoard[row][col].drawTile(player);
            makeMoveMatrix(board, player, row, col);
        }
    }

    //method moved from Tile
    void makeMoveMatrix(Board board, int player, int row, int col) {
        board.make_move(player, row, col);
    }


    Tile[][] getTileBoard() { return tileBoard; }

    class Tile extends StackPane {

        Text text = new Text();
        int row, column;

        Tile(int row, int col) {
            this.row = row; column = col;

            Rectangle border = new Rectangle(50, 50);
            border.setFill(Color.BURLYWOOD);
            border.setStroke(Color.BLACK);
            text.setFont(Font.font(40));
            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);
        }

        void drawTile(int player) {
            text.setText("O");
            if (player == Game.PLAYER_ONE) {
                text.setFill(Color.BLACK);
            } else {
                text.setFill(Color.WHITE);
            }
        }

        int getTileRow() { return row; }

        void setRow(int row) { this.row = row; }

        void setColumn(int column) { this.column = column; }

        int getTileCol() { return column; }
    }


    public static void main(String[] args) {
        launch(null);
    }
}

class Game  {// there is no need for Game to extend BoardGUI

    public static final int FREE = 0, PLAYER_ONE = 1, PLAYER_TWO = 2;
    private final BoardGUI gui;
    private final Board gameBoard;
    private final int boardSize = 15, winLength = 5;
    private final Random random = new Random(); //no need to create new Randon with every move
    //replace this attribute with property so you could listen to it
    //private boolean turn = true;
    private final BooleanProperty playerTurn = new SimpleBooleanProperty(true);

    private boolean isGameOver = false;

    Game(BoardGUI gui) { //get a reference to BoardGUI rather than constructing it
        gameBoard = new Board(boardSize, winLength);
        this.gui = gui;
        playerTurn.addListener( (obs,oldValue,newValue) ->{//listen to turn changes
            if(!newValue) {
                makeMoveAIRandom();
            }
        });
    }

    void makeMoveAIRandom() {

        if( playerTurn.get() ) return; //run only if not player turn

        List<int[]> availableMoves = gameBoard.getAvailableMoves();
        int index = random.nextInt(availableMoves.size());
        int[] move = availableMoves.get(index);

        gui.makeMove(gameBoard, PLAYER_TWO, move[0], move[1]);
        setPlayerTurnTrue();
        System.out.println("AI taken turn " + move[0] +"-"+ move[1]);
    }

    //void playerMakeMove(Game game, int row, int col) { //no need to path reference to this
    void playerMakeMove(int row, int col) {
        if(! playerTurn.get() ) return; //run only if player turn

        gui.makeMove(gameBoard, PLAYER_ONE, row, col);
        setPlayerTurnFalse();
        System.out.println("player taken turn " + row +"-"+col );
    }

    Board getGameBoard() { return gameBoard; }

    int getBoardSize () { return boardSize; }

    boolean isPlayerTurn() { return playerTurn.get(); }

    private void setPlayerTurnFalse() { playerTurn.set(false); }

    void setPlayerTurnTrue() { playerTurn.set(true); }

    boolean getGameOver () { return isGameOver; }

    private void setGameOver (boolean result) { isGameOver = result; }
}

class Board {

    private final int[][] board_matrix;
    private final int board_size, win_length;

    Board(int board_size, int win_length) {
        board_matrix = new int[board_size][board_size];
        this.board_size = board_size;
        this.win_length = win_length;

        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                board_matrix[i][j] = Game.FREE;
            }
        }
    }

    boolean isMoveAvailable(int row, int col) {

        return board_matrix[row][col] != Game.PLAYER_ONE && board_matrix[row][col] != Game.PLAYER_TWO ;
    }

    void make_move(int player, int x_pos, int y_pos) {
        if (player == Game.PLAYER_ONE) {
            board_matrix[x_pos][y_pos] = Game.PLAYER_ONE;
        } else {
            board_matrix[x_pos][y_pos] = Game.PLAYER_TWO;
        }
    }

    List<int[]> getAvailableMoves(){

        List<int[]> availableMoves = new ArrayList<>();
        for (int row = 0; row < board_size; row++) {
            for (int col = 0; col < board_size; col++) {
                if (board_matrix[row][col] == Game.FREE){
                    availableMoves.add(new int[]{ row, col});
                }
            }
        }

        return availableMoves;
    }
}