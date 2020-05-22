import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestRobot {

    public static void main(String[] args) {
        new TestRobot();
    }

    public TestRobot() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextArea ta;

        public TestPane() {

            setLayout(new BorderLayout());
            ta = new JTextArea(20, 20);
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);
            add(new JScrollPane(ta));

            JButton btn = new JButton("Start");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ta.requestFocusInWindow();
                    ta.append("Start\n");
                    SwingWorker worker = new SwingWorker<Object, Object>() {
                        @Override
                        protected Object doInBackground() throws Exception {

                            Robot bot = new Robot();
                            bot.setAutoDelay(1);

                            int duration = 3000;
                            long start = System.currentTimeMillis();
                            while (System.currentTimeMillis() - start < duration) {
                                bot.keyPress(KeyEvent.VK_R);
                                bot.keyRelease(KeyEvent.VK_R);
                            }
                            return null;

                        }

                        @Override
                        protected void done() {
                            ta.append("\nDone");
                        }
                    };
                    worker.execute();
                }
            });
            add(btn, BorderLayout.SOUTH);

        }
    }
}