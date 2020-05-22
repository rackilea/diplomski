import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConwayGame {

    static JPanel panel;
    static JFrame frame;

    public static void main(String[] args) throws InterruptedException {
        int[][] array = new int[40][40];

        array[19][15] = 1;
        array[19][16] = 1;
        array[19][19] = 1;
        array[19][20] = 1;
        array[19][21] = 1;
        array[18][18] = 1;
        array[17][16] = 1;

        panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawArray(array, g);
            }


        };
        frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    /*
     * Creates the graphic for Conway's game of life.
     */
    public static void drawArray(int[][] array, Graphics g) {
        int BOX_DIM = 10;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                g.drawRect(i * BOX_DIM, j * BOX_DIM, 10, 10);
                if (array[i][j] == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(i * BOX_DIM, j * BOX_DIM, 10, 10);
                }
                if (array[i][j] == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i * BOX_DIM, j * BOX_DIM, 10, 10);
                }
            }
        }

    }
}