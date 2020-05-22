import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FullScreenExample {

    public static void main(String[] args) throws InterruptedException {
        new FullScreenExample();
    }

    public FullScreenExample() throws InterruptedException {
        // Full screen frame set-up.
        JFrame frameFullScr = new JFrame();
        frameFullScr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameFullScr.setUndecorated(true);
        frameFullScr.add(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                if(frameFullScr.isVisible()) draw(this, g);
            }
        });
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frameFullScr);

        // Windowed frame set-up.
        JFrame frameWin = new JFrame();
        frameWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWin.setSize(512, 512);
        frameWin.add(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                if(frameWin.isVisible()) draw(this, g);
            }
        });

        Thread.sleep(5000);

        // Now let's go into a window...
        frameFullScr.setVisible(false);
        frameWin.setVisible(true);
    }

    private void draw(JComponent component, Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, component.getWidth(), component.getHeight());
        g.setColor(Color.RED);
        g.drawOval(32, 32, 256, 256);
    }

}