import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class SmileBack {

    private JFrame frame;

    private JPanel panel, container;

    private JButton loadButton;

    private JProgressBar progressBar;

    public static void main(String[] arguments) {
        new SmileBack().constructFrame();
    }

    public void constructFrame() {
        frame = new JFrame("RSTracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(getContentPane());
        // after this, everything is instantiated;
        frame.pack();
        setProgressBarVisibility(false);
        frame.setVisible(true);
    }

    public void setProgressBarVisibility(boolean visible) {
        progressBar.setVisible(visible);
    }

    public JPanel getContentPane() {
        panel = new JPanel(new BorderLayout());

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);

        loadButton = new JButton("Load memberlist");
        loadButton.setEnabled(true);
        loadButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        progressBar.setVisible(true);
                        // do my stuff here...
                        try {
                            Thread.sleep(2000); // just for the sake of example
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        progressBar.setVisible(false);
                    }

                }).start();
            }

        });

        container = new JPanel(new FlowLayout());
        container.add(loadButton);
        container.add(progressBar);

        panel.add(container);

        return panel;
    }
}