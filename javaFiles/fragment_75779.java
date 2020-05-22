import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GUI extends javax.swing.JFrame {

    private Timer SimpleTimer;

    public GUI() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel("   Time passed: 00:00:00   ");
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Restart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(jButton1);
        JPanel labelPanel = new JPanel();
        labelPanel.add(jLabel1);

        setLayout(new BorderLayout());
        add(labelPanel, BorderLayout.PAGE_START);
        add(btnPanel, BorderLayout.CENTER);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        startGame();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;

    private void startGame() {
        long startTime = System.currentTimeMillis();
        if (SimpleTimer != null) {
            SimpleTimer.stop();
        }
        SimpleTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long millis = System.currentTimeMillis() - startTime;
                jLabel1.setText("Time passed: " + String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(millis),
                        TimeUnit.MILLISECONDS.toMinutes(millis)
                                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES
                                .toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));
            }
        });
        SimpleTimer.start();
    }
}