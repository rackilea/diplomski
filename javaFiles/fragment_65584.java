import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

public class Test2 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        frame.add(panel);

        final Timer timer = new Timer(300, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int zufallszahl = (int)(Math.random() * 10 +1);
                System.out.println(zufallszahl);
            }
        });
        final JToggleButton toggle = new JToggleButton("Go");
        panel.add(toggle);
        toggle.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (toggle.isSelected()) {
                    timer.restart();
                } else {
                    timer.stop();
                }
            }
        }); 
    }

}