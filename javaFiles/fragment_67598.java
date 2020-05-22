import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class NumberButtons extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberButtons().setVisible(true);
            }
        });
    }
    private List<JButton> buttons = new ArrayList<JButton>();
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = buttons.indexOf(e.getSource());
            System.out.println("Number " + index + " pressed");         
        }
    };
    public NumberButtons() {
        JPanel pNum = new JPanel();
        pNum.setLayout(new GridLayout(3,4));
        for (int i = 0; i < 10; ++i) {
            JButton b = new JButton("" + i);
            b.addActionListener(listener);
            pNum.add(b);
            buttons.add(b);
        }
        this.add(pNum);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }   
}