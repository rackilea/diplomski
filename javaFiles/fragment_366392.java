import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;


public class Runner {
    public static void main(String[] args) {
        List<Card> tiles = new ArrayList<Card>();

        JFrame frame =  new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        int NUM_COLS = 5;
        int NUM_ROWS = 4;

        frame.setLayout(new GridLayout(NUM_ROWS, NUM_COLS));

        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                tiles.add(new Card(i * 8 + 10, j * 8 + 40));
            }
        }

        for (int i = 0; i < tiles.size(); i++) {
            frame.add(tiles.get(i));
            tiles.get(i).drawFaceDown();
        }

        frame.pack();
        frame.setVisible(true);

    }
}