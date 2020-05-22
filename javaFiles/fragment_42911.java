import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Sequence {

    public static void main(String[] args) {
        new Sequence();
    }

    public Sequence() {
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

        private List<SequencePane> panels = new ArrayList<>(4);

        private Timer timer;
        private int sequenceIndex;

        public TestPane() {
            setLayout(new BorderLayout());
            Color colors[] = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
            for (int index = 0; index < 4; index++) {
                panels.add(new SequencePane(colors[index]));
            }
            JPanel content = new JPanel(new GridLayout(2, 2));
            for (SequencePane pane : panels) {
                content.add(pane);
            }

            add(content);

            JButton wrong = new JButton("The wrong way");
            JButton timerButton = new JButton("The Timer way");
            JButton workerButton = new JButton("The Worker way");

            JPanel actions = new JPanel();
            actions.add(wrong);
            actions.add(timerButton);
            actions.add(workerButton);

            add(actions, BorderLayout.SOUTH);

            wrong.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Collections.shuffle(panels);
                    for (SequencePane pane : panels) {
                        try {
                            pane.setHighlighted(true);
                            Thread.sleep(250);
                            pane.setHighlighted(false);
                        } catch (InterruptedException ex) {
                        }
                    }
                }
            });

            timer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (sequenceIndex > 0) {
                        panels.get(sequenceIndex - 1).setHighlighted(false);
                    }

                    if (sequenceIndex < panels.size()) {
                        panels.get(sequenceIndex).setHighlighted(true);
                        sequenceIndex++;
                    } else {
                        timer.stop();
                        // All done, call some "play" method to begin playing
                    }
                }
            });

            timerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timer.stop();
                    Collections.shuffle(panels);
                    sequenceIndex = 0;
                    timer.start();
                }
            });

            SwingWorker worker = new SwingWorker<Object, SequenceState>() {
                @Override
                protected Object doInBackground() throws Exception {
                    for (SequencePane pane : panels) {
                        publish(new SequenceState(pane, true));
                        Thread.sleep(100);
                        publish(new SequenceState(pane, false));
                    }
                    return null;
                }

                @Override
                protected void process(List<SequenceState> chunks) {
                    SequenceState state = chunks.get(chunks.size() - 1);
                    state.applyState();
                }

                @Override
                protected void done() {
                    // Back in the EDT, call what ever "play" method you need
                }

            };

            workerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Collections.shuffle(panels);
                    SequenceWorker worker = new SequenceWorker();
                    worker.execute();
                }
            });

        }

        public class SequenceWorker extends SwingWorker<Object, SequenceState> {
                @Override
                protected Object doInBackground() throws Exception {
                    for (SequencePane pane : panels) {
                        publish(new SequenceState(pane, true));
                        Thread.sleep(250);
                        publish(new SequenceState(pane, false));
                    }
                    return null;
                }

                @Override
                protected void process(List<SequenceState> chunks) {
                    for (SequenceState state : chunks) {
                        state.applyState();
                    }
                }

                @Override
                protected void done() {
                    // Back in the EDT, call what ever "play" method you need
                }

            }

        public class SequenceState {

            private SequencePane sequencePane;
            private boolean highlighted;

            public SequenceState(SequencePane sequencePane, boolean highlighted) {
                this.sequencePane = sequencePane;
                this.highlighted = highlighted;
            }

            public SequencePane getSequencePane() {
                return sequencePane;
            }

            public boolean isHighlighted() {
                return highlighted;
            }

            public void applyState() {
                getSequencePane().setHighlighted(isHighlighted());
            }
        }

    }

    public class SequencePane extends JPanel {

        private boolean highlighted;

        public SequencePane(Color color) {
            setOpaque(false);
            setBackground(color);
        }

        public void setHighlighted(boolean highlighted) {
            this.highlighted = highlighted;
            repaint();
        }

        public boolean isHighlighted() {
            return highlighted;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (!isHighlighted()) {
                g2d.setComposite(AlphaComposite.SrcOver.derive(0.25f));
            }
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
        }

    }

}