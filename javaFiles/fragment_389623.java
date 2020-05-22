import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.TileObserver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class Move extends JPanel{

public static final long serialVersionUID = 1L;
public static final String IMAGE_PATH = "http://mathforum.org/alejandre/magic.square/4x4grid.gif";
public static final String IMAGE_PATH_PLAYER = "http://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Square-symbol.svg/50px-Square-symbol.svg.png";
public static final int STEP = 3;
public static final int TIMER_DELAY = STEP * 8;
public BufferedImage bkgrndImage = null;
public BufferedImage playerImage = null;
public Map<Direction, Boolean> directionMap = new HashMap<Direction, Boolean>();
public int playerX = 0;
public int playerY = 0;
private static int xPosition = 0;
private static int yPosition = 0;
private String s = "";
private JLabel jlbl1 = new JLabel("");
enum Direction {

    UP(KeyEvent.VK_UP, 0, -1), DOWN(KeyEvent.VK_DOWN, 0, 1),
    LEFT(KeyEvent.VK_LEFT, -1, 0), RIGHT(KeyEvent.VK_RIGHT, 1, 0);
    public int keyCode;
    public int xDirection;
    public int yDirection;

    private Direction(int keyCode, int xDirection, int yDirection) {
        this.keyCode = keyCode;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public int getXDirection() {
        return xDirection;
    }

    public int getYDirection() {
        return yDirection;
    }

}
public Move() {

    this.add(jlbl1,new Dimension(100,100));
    try {
        URL bkgrdImageURL = new URL(IMAGE_PATH);
        URL playerImageURL = new URL(IMAGE_PATH_PLAYER);
        bkgrndImage = ImageIO.read(bkgrdImageURL);
        playerImage = ImageIO.read(playerImageURL);
        setPreferredSize(new Dimension(bkgrndImage.getWidth(),          bkgrndImage.getHeight()));

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    for (Direction direction : Direction.values()) {
        directionMap.put(direction, false);
    }
    setKeyBindings();
    Timer timer = new Timer(TIMER_DELAY, new TimerListener());
    timer.start();

}

public void setKeyBindings() {
    InputMap inMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap actMap = getActionMap();
    for (final Direction direction : Direction.values()) {
        KeyStroke pressed = KeyStroke.getKeyStroke(direction.getKeyCode(), 0, false);
        KeyStroke released = KeyStroke.getKeyStroke(direction.getKeyCode(), 0, true);
        inMap.put(pressed, direction.toString() + "pressed");
        inMap.put(released, direction.toString() + "released");
        actMap.put(direction.toString() + "pressed", new AbstractAction() {

            public static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                directionMap.put(direction, true);
            }
        });
        actMap.put(direction.toString() + "released", new AbstractAction() {

            public static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                directionMap.put(direction, false);
            }
        });
    }

}
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (bkgrndImage != null) {
        g.drawImage(bkgrndImage, 0, 0, null);
    }
    if (playerImage != null) {
        g.drawImage(playerImage, playerX, playerY, null);
    }
}

public class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean moved = false;
        for (Direction direction : Direction.values()) {
            if (directionMap.get(direction)) {
                playerX += STEP * direction.getXDirection();
                playerY += STEP * direction.getYDirection();


                moved = true;
            }
        }
        if (moved) {
            int x = playerX - 2 * STEP;
            int y = playerY - 2 * STEP;
            int w = playerImage.getWidth() + 4 * STEP;
            int h = playerImage.getHeight() + 4 * STEP;
            Move.this.repaint(x, y, w, h); // !! repaint just the player
        }
        s = playerX+", "+playerY;
        jlbl1.setText(s);


    }
}

public static void createAndShowUI() {
    JFrame frame = new JFrame("MoveIcon");
    frame.getContentPane().add(new Move());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            createAndShowUI();

        }
    });
}
}