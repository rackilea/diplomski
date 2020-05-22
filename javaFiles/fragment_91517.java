import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SecondTabPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    JTextArea area;
    JTextField field;

    public SecondTabPanel() {

        this.setLayout(new BorderLayout(10, 10));

        field = new JTextField();
        this.add(field, BorderLayout.NORTH);
        area = new JTextArea();
        this.add(area, BorderLayout.CENTER);
        field.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent e) {
                area.setText(area.getText() + e.getKeyChar());
            }
        });
    }


}