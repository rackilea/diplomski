import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class JPanelButton extends JPanel {

    Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    public static void main(final String[] args) {

        JFrame frame = new JFrame();

        final JPanelButton panel = new JPanelButton();
        panel.raiseBorder();

        panel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(final MouseEvent e) {
                panel.lowerBorder();

            }

            @Override
            public void mouseReleased(final MouseEvent e) {
                panel.raiseBorder();

            }

        });

        panel.setFocusable(true); // you need this or the panel won't get the key events
        panel.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(final KeyEvent e) {
                panel.lowerBorder();

            }

            @Override
            public void keyReleased(final KeyEvent e) {
                panel.raiseBorder();

            }
        });

        frame.setContentPane(panel);
        frame.setSize(100, 100);
        frame.setVisible(true);

    }

    public void raiseBorder() {

        setBorder(raisedetched);
    }

    public void lowerBorder() {

        setBorder(loweredetched);
    }

}