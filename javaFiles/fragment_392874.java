import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test extends JApplet {

    private JLabel label1 = new JLabel("60");
    private JLabel label2 = new JLabel("Yes");
    private JButton jbt1 = new JButton("Yes");
    private JButton jbt2 = new JButton("No");
    private int count = 60;
    private Timer timer;

    public Test() {
        JPanel panel1 = new JPanel(new GridLayout(1, 2));
        panel1.add(label1);
        panel1.add(label2);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        JPanel panel2 = new JPanel();
        panel2.add(jbt1);
        panel2.add(jbt2);

        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count == 0) timer.stop();

                label1.setText(String.valueOf(count));

            }
        });
        timer.start();

        jbt1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                label2.setText("Yes");
            }
        });
        jbt2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                label2.setText("No");
            }
        });
    }
}