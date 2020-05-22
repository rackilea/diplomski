import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {

        // display a user friendly console
        // build a player for this user            
        // find a game
        // register the player to the game

        // for testing purpose the console builds a player, builds the game, registers the player to the game and starts the game
        Player player1 = new Player(new Scanner(System.in), System.out);

        Game game = new Game();
        game.registerPlayer(player1);

        game.run();
    }
}