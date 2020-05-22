import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class MyJPanel extends JPanel {

    private int x = 0;
    private int y = 0;

    public MyJPanel() {
        setPreferredSize(new Dimension(200,200));
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(x,y,20,20);
    }

    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        switch (k) {
            case KeyEvent.VK_D:
                x++;
                break;
            case KeyEvent.VK_A:
                x--;
                break;
            case KeyEvent.VK_W:
                y--;
                break;
            case KeyEvent.VK_S:
                y++;
                break;
        }
    }
}