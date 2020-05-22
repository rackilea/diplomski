import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;

public class SwingWorkerTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JPanel panel = new JPanel(new GridLayout(0, 1));
                new SwingWorker<Void, String>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        Random random = new Random();
                        int count = 1;
                        while (count < 100) {
                            publish("Button " + (count++));
                            Thread.sleep(random.nextInt(1000) + 500);
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<String> chunks) {
                        for (String text : chunks) {
                            panel.add(new JButton(new AbstractAction(text) {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    panel.remove((JButton) e.getSource());
                                    panel.revalidate();
                                    panel.repaint();
                                }
                            }));
                        }
                        panel.revalidate();
                        panel.repaint();
                    }
                }.execute();

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new JScrollPane(panel));
                frame.setPreferredSize(new Dimension(400, 300));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}