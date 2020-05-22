import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke; 


public class Graphic extends JFrame implements ActionListener {

private JButton button;

    public Graphic() {
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
            getRootPane().getActionMap().put("Cancel", new AbstractAction(){ //$NON-NLS-1$
                public void actionPerformed(ActionEvent e)
                {
                    dispose();
                }
            });

        button = new JButton();
        button.addActionListener(this);
        button.setIcon(new ImageIcon("Image.jpg"));

        this.getContentPane().add(button);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            //some code 
        }
   } 

    public static void main(String[] args) {
        JFrame bec = new Graphic();
        bec.setDefaultCloseOperation(Graphic.EXIT_ON_CLOSE);
        bec.setSize(1731, 563);
        bec.setVisible(true);
        bec.setTitle("title");
        bec.requestFocus();
    }

}