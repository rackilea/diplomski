import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapArray {

    private static final int SIZE = 4;
    private static final JPanel[][] tiles = new JPanel[SIZE][SIZE];

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setLayout(new GridLayout(SIZE, SIZE));
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles[0].length; j++) {
                        tiles[i][j] = new JPanel(new GridLayout());
                        tiles[i][j].add(new JLabel(
                            new ImageIcon("image.gif")));
                        frame.add(tiles[i][j]);
                    }
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}