import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class GameSetup extends JPanel implements MouseMotionListener {

    public static JFrame njf = new JFrame("Test");
    public static int x = 0, y = 0;
    public static boolean enteredZone = false;

    public static void main(String[] args) {
        GameSetup gs = new GameSetup();
        gs.addMouseMotionListener(gs);
        njf.add(gs);
        njf.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBackground(Color.BLACK);

        g.setColor(Color.GREEN);
        g.fillRect(150, 75, 200, 100);
        g.setColor(Color.ORANGE);
        g.drawString("Play", 239, 123);


        if (x > 100 && y > 100 || enteredZone){
            g.drawRect(10, 10, 100, 100);
            enteredZone = true;
        }
    }

    public GameSetup() {
        super();
        setSize(500, 500);
        njf.setSize(500,500);
        njf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        njf.setResizable(false);
        njf.setLocationRelativeTo(null);
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        if (x > 100 && y > 100) repaint();
    }

}