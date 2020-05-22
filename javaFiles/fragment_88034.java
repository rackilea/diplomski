import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BlinkyTheButton {

    public static void main(String[] args) {
        new BlinkyTheButton();
    }

    public BlinkyTheButton() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JButton blinky;

        public TestPane() {
            blinky = new JButton("Blinky");
            blinky.setOpaque(true);
            blinky.addActionListener(new ActionListener() {
                private BlinkWorker worker;
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (worker == null || worker.getState() == SwingWorker.StateValue.DONE) {
                        worker = new BlinkWorker(blinky, Color.RED);
                        worker.addPropertyChangeListener(new PropertyChangeListener() {
                            @Override
                            public void propertyChange(PropertyChangeEvent evt) {
                                SwingWorker worker = (SwingWorker) evt.getSource();
                                if ("state".equals(evt.getPropertyName())) {
                                    if (worker.getState() == SwingWorker.StateValue.DONE) {
                                        // this is where you would then call the method to
                                        // update the state for a new question
                                    }
                                }
                            }
                        });
                        worker.execute();
                    }
                }
            });
            setLayout(new GridBagLayout());
            add(blinky);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public class BlinkWorker extends SwingWorker<Void, Color> {

            private JButton btn;
            private Color color;
            private Color normal;

            public BlinkWorker(JButton btn, Color color) {
                this.btn = btn;
                normal = btn.getBackground();
                this.color = color;
            }

            @Override
            protected Void doInBackground() throws Exception {
                for (int index = 10; index > 1; index--) {
                    publish(color);
                    Thread.sleep(index * 100);
                    publish(normal);
                    Thread.sleep(index * 100);
                }
                return null;
            }

            @Override
            protected void process(List<Color> chunks) {
                Color color =  chunks.get(chunks.size() - 1);
                btn.setBackground(color);
            }

        }

    }

}