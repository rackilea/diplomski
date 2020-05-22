import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TestFrame extends JFrame {

    private JLabel lbl;

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        lbl = new JLabel(" ");
        JButton setText = new JButton("setText");
        setText.addActionListener(getActionListener());
        add(lbl);
        add(setText,BorderLayout.SOUTH);
    }

    private ActionListener getActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lbl.setText("wait...");
                Timer t = new Timer(5000, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        lbl.setText("");
                        setState(JFrame.ICONIFIED);
                    }
                });
                t.setRepeats(false);
                t.start();
            }
        };
    }

    public static void main(String args[]) {
        new TestFrame();
    }

}