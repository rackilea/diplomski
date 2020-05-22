import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ball extends JFrame implements MouseListener {

    int x = 20;
    int y = 20;
    int rad = 20;

    boolean temp1 = true;
    boolean temp2 = true;
    boolean temp3 = true;

    Ball() {
        setSize(500, 500);
        setVisible(true);
        // the correct way to animate a Swing GUI
        ActionListener animationListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (temp3) {
                    move();
                    repaint();
                }
            }
        };
        Timer timer = new Timer(20, animationListener);
        timer.start();
        // add the listener to the frame!
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent me) {
        System.out.println("Hee");
        temp3 = false;
    }

    public void mouseEntered(MouseEvent me) {
        temp3 = false;
    }

    public void mouseExited(MouseEvent me) {
        System.out.println("");
    }

    public void mouseReleased(MouseEvent me) {
        System.out.println("");
    }

    public void mousePressed(MouseEvent me) {
        System.out.println("");
    }

    void move() {

        if (x == rad && y == rad) {
            temp1 = temp2 = true;
        }

        if (x < (getWidth() - rad) && temp1) {
            x = x + 1;
        }

        if (x == (getWidth() - rad) && y < getHeight() - rad) {
            x = getWidth() - rad;
            y = y + 1;
        }

        if (y == getHeight() - rad && temp2) {
            temp1 = false;
            y = getHeight() - rad;
            x = x - 1;
        }

        if (x == rad) {
            temp2 = false;
            x = rad;
            y = y - 1;
        }

        try {
            Thread.sleep(1);
        } catch (Exception e) {

        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, rad, rad);
    }

    public static void main(String[] args) {
        Ball b = new Ball();
    }
}