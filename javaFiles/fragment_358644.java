import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sad {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sad window = new Sad();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Sad() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 512, 399);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Grafik grafik = new Grafik(20, 20, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(grafik);

        JButton btnNes = new JButton("Nes");
        btnNes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                grafik.setEllipseVisible(true);
                panel.repaint();
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnNes);
        panel.add(btnPanel, BorderLayout.SOUTH);

        frame.setContentPane(panel);
    }

}

class Grafik extends JPanel {

    private int x;
    private int y;
    private int r;
    private boolean ellipseVisible;

    public Grafik(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isEllipseVisible()) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Ellipse2D circ = new Ellipse2D.Float(x, y, r, r);
            g2.setColor(Color.RED);
            g2.draw(circ);
        }
    }

    public boolean isEllipseVisible() {
        return ellipseVisible;
    }

    public void setEllipseVisible(boolean ellipseVisible) {
        this.ellipseVisible = ellipseVisible;
    }

}