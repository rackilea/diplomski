import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Rotation {

    JButton jbtn = new JButton("Stop");
    component jpn2 = new component();    //created a JPanel named jpn2 and got a reference to its timer object.
    Timer timer = jpn2.timer;

    Rotation() {


        JFrame jfrm = new JFrame("Rotating a square about a center");

        // jfrm.setLayout(new FlowLayout());
        jfrm.setLayout(new GridLayout(2, 1));

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Stop")) {
                    timer.stop();
                    jbtn.setText("Spin");
                }
                if (e.getActionCommand().equals("Spin")) {
                    timer.start();
                    jbtn.setText("Stop");
                }

            }
        });

        jfrm.add(jpn2);
        jfrm.add(jbtn);

        jfrm.pack();
        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Rotation();
            }
        });
    }
}

class component extends JPanel implements ActionListener {

    Timer timer;
    int theta = 0;
    int width = 100, height = 100;

    component() {
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(theta, 100, 100);
        g2.fillRect(50, 50, width, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width * 2, height * 2);//multiply by 2 to fit while rotating
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Changing a global variable and then drawing the rectangle again and hence indirectly the square rotates.
        theta = theta + 10;
        if (theta == 360) {
            theta = 0;
        }
        repaint();
    }
}