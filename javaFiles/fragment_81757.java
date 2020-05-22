import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Sandbox {

    DrawingStar canvas;

    public static void main(String[] args) {
        new Sandbox();
    }

    public Sandbox() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                canvas = new DrawingStar();
                frame.getContentPane().add(canvas);
                frame.setSize(250, 250);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    class DrawingStar extends JPanel {

        Vector generalPaths;
        private List<Color> colors;
        private int colorIndex = 0;
        private Color color;

        public DrawingStar() {

            colors = new ArrayList<Color>();

            for (int i = 0; i < 3; i++) {
                colors.add(createRandomColor());
            }

            color = colors.get(0);

            setBackground(Color.white);
            generalPaths = new Vector();

            GeneralPath gp1;

            gp1 = new GeneralPath();
            gp1.moveTo(50, 120);
            gp1.lineTo(70, 180);
            gp1.lineTo(20, 140);
            gp1.lineTo(80, 140);
            gp1.lineTo(30, 180);
            gp1.closePath();
            generalPaths.addElement(gp1);

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    colorIndex++;
                    if (colorIndex >= colors.size()) {
                        colorIndex = 0;
                    }

                    color = colors.get(colorIndex);
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            Graphics2D g2D = (Graphics2D) g;
            g2D.translate(70.0f, -85.0f);
            g2D.draw((GeneralPath) generalPaths.elementAt(0));

            g2D.setColor(color);
            g2D.fill((GeneralPath) generalPaths.elementAt(0));
        }

        private Color createRandomColor() {
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            Color color = new Color(r, g, b);

            return color;
        }

    }
}