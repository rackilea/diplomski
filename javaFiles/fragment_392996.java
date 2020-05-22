import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboTest extends JFrame {
    private ArrayList<Game> gamesList = new ArrayList<Game>();

    private class Game {
        private String title = "";

        public Game() {}

        public Game(String title, int x, int y, double z, int a) {
            this.title = title;
        }

        /********************************************************/
        /********************************************************/
        @Override
        public String toString() {
            return this.title;
        }
        /********************************************************/
        /********************************************************/
    }

    public ComboTest() {
        gamesList.add(new Game());
        gamesList.add(new Game("[Halo: Reach]", 3, 1, 108.00d, 2));
        gamesList.add(new Game("[Dead Space]", 3, 2, 80.00d, 1));
        add(getCombo());
        setSize(320, 80);
        setVisible(true);
    }

    private JComboBox getCombo() {
        JComboBox box = new JComboBox(getGames());
        return box;
    }

    private Object[] getGames() {
        return gamesList.toArray();
    }

    public static void main(String[] args) {
        new ComboTest();
    }
}