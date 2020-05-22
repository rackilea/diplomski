import java.awt.event.*;
import javax.swing.*;

class PopUpMenuDemo {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            public void run() {
                final JButton b = new JButton("Pop Up");

                final JPopupMenu menu = new JPopupMenu("Menu");
                menu.add("A");
                menu.add("B");
                menu.add("C");
                b.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        menu.show(b, b.getWidth()/2, b.getHeight()/2);
                    }
                } );
                JOptionPane.showMessageDialog(null,b);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}