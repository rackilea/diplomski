import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FirstTabPanel extends JPanel implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JButton button;
    JTextField tf;
    public FirstTabPanel() {
        tf = new JTextField("Textfield");
        this.add(tf);
        button = new JButton("Button");
        button.addActionListener(this);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(button)) {
            tf.setText("Button on was clicked!");
        }
    }
}