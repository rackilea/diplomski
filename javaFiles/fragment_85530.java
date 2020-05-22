import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Screen {

    private JFrame window;

    public static void main(String[] args) {

        //creat UI on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Screen();
            }
        });
    }

    public Screen() {
        window = new JFrame("Multiply components panel") {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 400);
            }
        };

        window.setLayout(null);//only reason this is warrented is because its a gmae using JPanels as game objects thus we need full control over its placing
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//changed from DISPOSE to EXIT so Timers  will be exited too

        final Box b1 = new Box(10, 10, 50, 50, "box1");

        final Box b2 = new Box(100, 100, 50, 50, "box2");

        window.add(b1);
        window.add(b2);

        window.pack();
        window.setVisible(true);

        Timer timer = new Timer(200, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b1.update();
                b2.update();
            }
        });
        timer.setInitialDelay(0);
        timer.start();

    }
}

class Box extends JPanel {

    int x, y, w, h;
    private String name;

    public Box(int x, int y, int w, int h, String name) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.name = name;
        setBounds(x, y, w, h);//let the Box class handle setting the bounds more elegant OOP
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println(this.name.equalsIgnoreCase("box1"));
        if (this.name.equalsIgnoreCase("box1")) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, w, h);
        } else {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, w, h);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    public void update() {
        if (this.name.equalsIgnoreCase("box1")) {
            x++;
        } else {
            y++;
        }
        this.setBounds(x, y, w, h);//set the new bounds so box may be updated
        System.out.println("Current " + name + ": X: " + x + ", Y: " + y + ", W: " + w + ", H: " + h);
        revalidate();
        repaint();
    }
}