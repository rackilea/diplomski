import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class RudeProgressBar extends JFrame {

    private JButton button;

    public RudeProgressBar() {
        setTitle("Rude Progress Bar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        button = new JButton("Do teh work");
        add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(RudeProgressBar.this, true);
                dialog.setTitle("Doing teh work");
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                final JProgressBar progressBar = new JProgressBar(0, 100);
                dialog.setLayout(new BorderLayout());
                dialog.add(progressBar);
                dialog.setSize(100, 100);
                dialog.setLocationRelativeTo(RudeProgressBar.this);
                MyTask task = new MyTask(dialog);
                task.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if ("progress".equals(evt.getPropertyName())) {
                            progressBar.setValue((Integer)evt.getNewValue());
                        }
                    }
                });
                task.execute();
            }
        });

        setSize(200, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RudeProgressBar().setVisible(true);
            }
        });
    }

    private class MyTask extends SwingWorker<Void, Void> {

        private final JDialog dialog;

        public MyTask(JDialog dialog) {
            this.dialog = dialog;
        }

        @Override
        protected Void doInBackground() throws Exception {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    dialog.setVisible(true);
                }
            });

            int progress = 0;
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                setProgress(progress += 20);
            }            

            return null;
        }

        @Override
        protected void done() {
            dialog.setVisible(false);
            dialog.dispose();
        }
    }
}