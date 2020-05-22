import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

    private JLabel countLabel1 = new JLabel("0");
    private JLabel statusLabel = new JLabel("Task not completed.");
    private JButton startButton = new JButton("Start");

    private MyThread myThread;

    public MainFrame(String title) {
        super(title);

        setLayout(new GridBagLayout());

        countLabel1.setFont(new Font("serif", Font.BOLD, 28));

        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        add(countLabel1, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        add(statusLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        add(startButton, gc);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                start();
            }
        });

        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void start() {
        if (myThread != null) {
            myThread.setRunning(false);
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                statusLabel.setText("Task not completed.");
            }
        });
        myThread = new MyThread(countLabel1, statusLabel);
        Thread thread = new Thread(myThread);
        thread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame("SwingWorker Demo");
            }
        });
    }
}

class MyThread implements Runnable {

    public MyThread(JLabel countLabel1, JLabel statusLabel) {
        this.countLabel1 = countLabel1;
        this.statusLabel = statusLabel;
    }

    private boolean running = true;
    private JLabel countLabel1, statusLabel;

    public void run() {

        // Simulate doing something useful.
        for (int i = 0; i <= 10; i++) {

            if (running) {
                final int count = i;

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        if (running) {
                            countLabel1.setText(Integer.toString(count));

                            if (count == 10) {
                                SwingUtilities.invokeLater(new Runnable() {
                                    public void run() {
                                        statusLabel.setText("Completed.");
                                    }
                                });
                            }
                        }
                    }
                });
            } else {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}