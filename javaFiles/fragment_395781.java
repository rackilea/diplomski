import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class LongWaiting {

    public static void main(String[] args) {
        new LongWaiting();
    }

    public LongWaiting() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JLabel("Loading stuff"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Loader loader = new Loader(frame);
                loader.execute();

            }

        });
    }

    public class Loader extends SwingWorker {

        private ProgressPane progressPane;
        private JDialog dialog;

        public Loader(Frame owner) {
            progressPane = new ProgressPane();
            progressPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            dialog = new JDialog(owner, "Loading", true);
            dialog.add(progressPane);
            dialog.pack();
            dialog.setLocationRelativeTo(owner);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("state".equals(evt.getPropertyName())) {
                        if (getState() == StateValue.STARTED) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    if (getState() == StateValue.STARTED) {
                                        dialog.setVisible(true);
                                    }
                                }
                            });
                        } 
                    } 
                }
            });
        }

        @Override
        protected Object doInBackground() throws Exception {
            Thread.sleep(10000);
            return null;
        }

        @Override
        protected void done() {
            dialog.dispose();
        }

    }

    public class ProgressPane extends JPanel {

        private JLabel message;
        private JProgressBar pb;

        public ProgressPane() {
            message = new JLabel("Loading...");
            pb = new JProgressBar();
            pb.setIndeterminate(true);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(2, 0, 2, 0);
            add(message, gbc);
            add(pb, gbc);
        }

    }

}