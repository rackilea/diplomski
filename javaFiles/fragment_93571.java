import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game001 extends JFrame {

    public Game001() {
        GameScreen p1 = new GameScreen();
        add(p1);
        Timer t = new Timer(1000, new ReDraw(p1));
        t.start();
    }

    public static void main(String[] args) {
        Game001 g = new Game001();
        g.setLocation(400, 200);
        g.setSize(700, 600);
        g.setVisible(true);
    }
}

class ReDraw implements ActionListener {

    static int count = 0;
    static int posX = 603;
    static int posY = 210;
    static int velX = 50;
    static int velY = 50;
    GameScreen gameScreen;

    ReDraw(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void actionPerformed(ActionEvent e) {
        count++;

        posX -= velX;
        posY -= velY;
        System.out.println("Flag 1: " + posX + " " + posY);
        gameScreen.repaint();

        if (count == 4) {
            ((Timer) e.getSource()).stop();
        }
    }
}

class GameScreen extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.orange);
        g.fillRect(654, 200, 30, 100);

        g.setColor(Color.red);
        g.fillOval(ReDraw.posX, ReDraw.posY, 50, 50);
    }
}