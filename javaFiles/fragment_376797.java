import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Swing extends JFrame{

    Swing() {
    //    initComponents();        
        setVisible(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JButton pnlButons = new JButton();
        pnlButons.setSize(pnlButons.getHeight(),JFrame.MAXIMIZED_VERT);

        add(pnlButons,BorderLayout.WEST);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        new Swing();
    }
}