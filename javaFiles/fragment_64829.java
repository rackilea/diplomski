import java.awt.*;
import javax.swing.*;

public class Game {

    private JFrame frame = null;
    private Canvas canvas = null;
    private String NAME = "Moronically Named Game";
    int width = 500;
    int height = 200;

    public Game() {

        frame = new JFrame(NAME);
        canvas = new Canvas();

        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(width, height);

        frame.add(canvas, BorderLayout.CENTER);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.requestFocus();

        JPanel panel = new JPanel();
        JButton play = new JButton("Hi");

        panel.add(play);
        frame.getContentPane().add(panel);
        panel.setPreferredSize(new Dimension(width, height));

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                Game o = new Game();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}