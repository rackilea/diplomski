import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WalkingMan extends JPanel implements KeyListener {
    int x = 0;
    int y = 0;

    @Override
    public void paintComponent(Graphics g) { // Overide paintComponent, not paint
        super.paintComponent(g);
        g.fillOval(x, y, 150, 150);
    }

    public WalkingMan() { // Class Constructor
        setFocusable(true); // KeyListeners only work if the component is focusable
        addKeyListener(this); // Add the KeyListener implemented by this class to the instance
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Walking Man");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WalkingMan game = new WalkingMan();
        frame.add(game);

        frame.setSize(1080, 720);
        frame.setVisible(true); // Call setVisible after adding the components

        game.requestFocusInWindow(); // Request focus for the panel
    }

    public static void main(String[] args) throws InterruptedException {
        new WalkingMan().createAndShowGUI();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}