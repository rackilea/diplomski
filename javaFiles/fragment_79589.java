import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author oliver
 */
public class Fereastra extends JFrame implements Runnable {

public JFrame jr;
public JButton bt;
public JLabel l;
public JLabel l2;
public Fereastra[] thread;
public boolean deblocat = true;

public Fereastra(Fereastra[] thread) {
    this.thread = thread;
    jr = new JFrame();
    jr.setSize(250, 250);
    jr.setLayout(new FlowLayout());
    bt = new JButton();
    jr.add(bt);
    bt.setText("OK");
    bt.setBackground(Color.cyan);
    l2 = new JLabel();
    l2.setText("Buton activ");
    jr.add(l2);
    jr.setVisible(true);

}

public void run() {

    bt.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            bt.setEnabled(false);

            deblocat = true;

            for (int c = 0; c < Hauptklasse.i; c++) {

                if (thread[c] != null && thread[c].bt.isEnabled()) {
                    deblocat = false;
                    break;
                }

            }

            if (deblocat == true) {
                for (int c = 0; c < Hauptklasse.i; c++) {
                    if (thread[c] != null) {
                        thread[c].bt.setEnabled(true);
                    }
                }
            }

        }
    });

}

}