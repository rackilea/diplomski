import java.awt.Dimension;
import javax.swing.*;

public class Game extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = 300;
    private int prefW;
    private int prefH;

    public Game(int prefW, int prefH) {
        this.prefW = prefW;
        this.prefH = prefH;
    }

    public Game() {
        this(PREF_W, PREF_H);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(prefW, prefH);
    }

    private static void createAndShowGui() {
        int height = 500; 
        int width =(int) (height*1.56); //height = 500, width = 780;

        Game game = new Game(width, height);

        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(game);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        System.out.println("Frame size: " + frame.getSize());
        System.out.println("game size: " + game.getSize());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}