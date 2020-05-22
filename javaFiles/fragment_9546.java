import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class _Newmain extends Canvas {
    private static int renderSizeX = 25;
    private static int renderSizeY = 25;

    private point player = new point(10,10,'X');
    public _Newmain() {
        setSize(new Dimension(500, 500));
        addKeyListener(new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent evt) {
                    moveIt(evt);
                }
            });
    }

    public void paint(Graphics g) {
        String text = m2.outputScreen(new point[]{player});
        int x = 20; int y = 20;
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
        //g.drawString(m2.outputScreen(new point[]{player}), 20, 20);
    }

    public void moveIt(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
            player.moveY(1);
            break;
            case KeyEvent.VK_UP:
            player.moveY(-1);
            break;
            case KeyEvent.VK_LEFT:
            player.moveX(-1);
            break;
            case KeyEvent.VK_RIGHT:
            player.moveX(1);
            break;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TEXT BASED GAME WRITTEN BY SHANE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _Newmain ex = new _Newmain();
        frame.getContentPane().add(ex);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        ex.requestFocus();

    }
}