import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class GameFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public GameFrame() {
        super("Game Frame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(new GamePanel(), BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {    
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new GameFrame();
                frame.setVisible(true);
            }
        });     
    }
}

class GamePanel extends JPanel implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;
    private static final Dimension PANEL_SIZE = new Dimension(640, 480);
    private static final int REFRESH_RATE = 1000;
    private static final int CHARACTER_WIDTH = 32;
    private static final int CHARACTER_HEIGHT = 64;

    private Timer timer = new Timer(REFRESH_RATE, this);
    private int currentRow = 0;
    private int currentCol = 0;
    private int randomRow = 0;
    private int randomCol = 0;

    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer.start();      
    }

    public Dimension getPreferredSize() {
        return PANEL_SIZE;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawOval(randomCol, randomRow, CHARACTER_WIDTH, CHARACTER_HEIGHT);
        g.drawRect(currentCol, currentRow, CHARACTER_WIDTH, CHARACTER_HEIGHT);
    }

    public void actionPerformed(ActionEvent e) {
        int min = 0;
        int maxRow = (int)PANEL_SIZE.getHeight() - CHARACTER_HEIGHT;
        int maxCol =  (int)PANEL_SIZE.getWidth() - CHARACTER_WIDTH;

        Random rand = new Random();
        randomRow = rand.nextInt((maxRow - min) + 1) + min;
        randomCol = rand.nextInt((maxCol - min) + 1) + min;

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        int rowIncrement = 0;
        int colIncrement = 0;

        if(code == KeyEvent.VK_LEFT) {
            colIncrement--;
        }
        else if(code == KeyEvent.VK_RIGHT) {
            colIncrement++;
        }
        else if(code == KeyEvent.VK_UP) {
            rowIncrement--;
        }
        else {
            if(code == KeyEvent.VK_DOWN) {
                rowIncrement++;
            }
        }

        if(isInBounds(rowIncrement, colIncrement)) {
            currentRow += rowIncrement;
            currentCol += colIncrement;
            repaint();
        }
    }

    private boolean isInBounds(int rowIncrement, int colIncrement) {
        int top = currentRow + rowIncrement;
        int left = currentCol + colIncrement;
        int right = left + CHARACTER_WIDTH;
        int bottom = top + CHARACTER_HEIGHT;

        return (top >= 0 && left >= 0 && right <= PANEL_SIZE.getWidth() && bottom <= PANEL_SIZE.getHeight());       
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}