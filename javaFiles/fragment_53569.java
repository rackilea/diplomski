import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

/** Some users are NOT addicted to the mouse!  Which is why
it would be better to add an ActionListener to a JCheckBox. */
class CheckBoxTest {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            public void run() {
                JPanel p = new JPanel(new GridLayout(0,1,20,20));

                JCheckBox cb1 = new JCheckBox("Broken on keyboard");
                cb1.addMouseListener( new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        System.out.println("Mouse click");
                    }
                } );
                p.add( cb1 );

                JCheckBox cb2 = new JCheckBox("Works for keyboard or mouse!");
                cb2.addActionListener( new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        System.out.println("Event detected!");
                    }
                } );
                p.add( cb2 );

                JOptionPane.showMessageDialog(null, p);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}