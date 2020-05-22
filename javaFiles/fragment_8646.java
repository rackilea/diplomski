import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;

public class ProjectFunctionTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Project Function");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.add(new ProjFunctMainPanel());
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);
            // mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            mainFrame.setVisible(true);
        });
    }
}

class ProjFunctMainPanel extends JPanel {
    private static final String[] BUTTON_TEXTS = {"Open", "Save", "Edit", "Exit"};
    private ProjFunctDrawingPanel drawingPanel = new ProjFunctDrawingPanel();

    public ProjFunctMainPanel() {
        // an inner jpanel to hold our jbuttons and uses grid layout
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        for (String btnText : BUTTON_TEXTS) {
            buttonPanel.add(new JButton(btnText));
        }

        // a wrapper jpanel to hold the button panel above at its top
        // so the buttons are loaded top-right
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(buttonPanel, BorderLayout.PAGE_START);

        // make outer panel use borderlayout
        setLayout(new BorderLayout());
        add(drawingPanel, BorderLayout.CENTER); // add drawing to the center
        add(rightPanel, BorderLayout.LINE_END);  // and wrapper panel with buttons to the right
    }
}

class ProjFunctDrawingPanel extends JPanel {
    private static final int PANEL_W = 1000;
    private static final int PANEL_H = 900;

    public ProjFunctDrawingPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }

    // this will set the preferred size of the jpanel to be one that fits the image
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();            
        } else {
            return new Dimension(PANEL_W, PANEL_H);
        }
    }

    // draw in a JPanel's paintComponent method
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // don't forget to call the super's method
        g.setColor(new Color(204, 204, 204));
        g.drawLine(0, 900, 1000, 900);
        g.drawLine(0, 800, 1000, 800);
        g.drawLine(0, 700, 1000, 700);
        g.drawLine(0, 600, 1000, 600);
        g.drawLine(0, 400, 1000, 400);
        g.drawLine(0, 300, 1000, 300);
        g.drawLine(0, 200, 1000, 200);
        g.drawLine(0, 100, 1000, 100);
        g.drawLine(100, 0, 100, 1000);
        g.drawLine(200, 0, 200, 1000);
        g.drawLine(300, 0, 300, 1000);
        g.drawLine(400, 0, 400, 1000);
        g.drawLine(600, 0, 600, 1000);
        g.drawLine(700, 0, 700, 1000);
        g.drawLine(800, 0, 800, 1000);
        g.drawLine(900, 0, 900, 1000);
        g.setColor(Color.BLACK);
        g.drawRect(0, 500, 1000, 1);
        g.drawRect(500, 0, 1, 1000);
        g.setColor(Color.RED);
        linear(0.25, 1, g);
        g.setColor(Color.BLUE);
        linear(-3, -2.5, g);
    }

    public void linear(double s, double c, Graphics g) {
        int Anzpunkte = 0;
        c = c * 100;
        int x = 500, y = 500 - (int) c;
        g.drawOval(x, y, 2, 2);
        y = y - (int) s;
        double abtrag = s - (int) s;
        System.out.println("Punkt   X-Achse  Y-Achse   Abtrag   Steigung");
        Anzpunkte++;
        System.out.println("" + Anzpunkte + "      " + x + "      " + y + "       " + abtrag + "   " + s);
        while (x < 1000 && y < 1000 && x > 0 && y > 0) {
            x++;
            g.drawOval(x, y, 2, 2);
            Anzpunkte++;
            System.out.println("" + Anzpunkte + "      " + x + "      " + y + "       " + abtrag + "   " + s);
            if (abtrag >= 1 || abtrag <= -1) {
                y = y - (int) s;
                y = y - (int) abtrag;
                abtrag = s - (int) s;
            } else {
                y = y - (int) s;
                abtrag = abtrag + s - (int) s;
            }
        }
        x = 500;
        y = 500 - (int) c;
        while (x < 1000 && y < 1000 && x > 0 && y > 0) {
            x--;
            g.drawOval(x, y, 2, 2);
            Anzpunkte++;
            System.out.println("" + Anzpunkte + "      " + x + "      " + y + "       " + abtrag + "   " + s);
            if (abtrag >= 1 || abtrag <= -1) {
                y = y + (int) s;
                y = y + (int) abtrag;
                abtrag = s - (int) s;
            } else {
                y = y + (int) s;
                abtrag = abtrag + s - (int) s;
            }
        }
    }
}