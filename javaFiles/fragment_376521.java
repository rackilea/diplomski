import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Runner {

    public static void main(String[] args) {
        new Runner();
    }

    public Runner() {
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

        private JTextArea ta;

        public TestPane() {
            setLayout(new BorderLayout());
            ta = new JTextArea(25, 80);
            add(new JScrollPane(ta));

            JButton execute = new JButton("Make it so");
            execute.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    execute.setEnabled(false);
                    CommandWorker worker = new CommandWorker(ta, "cmd.exe", "/c", "cd \"C:\\usmt\" && loadstate.bat");
                    worker.addPropertyChangeListener(new PropertyChangeListener() {
                        @Override
                        public void propertyChange(PropertyChangeEvent evt) {
                            switch (evt.getPropertyName()) {
                                case "state":
                                    SwingWorker work = (SwingWorker) evt.getSource();
                                    switch (worker.getState()) {
                                        case DONE: {
                                            try {
                                                worker.get();
                                            } catch (InterruptedException | ExecutionException ex) {
                                                ex.printStackTrace();;
                                                JOptionPane.showMessageDialog(TestPane.this, "Execution of command failed: " + ex.getMessage());
                                            } finally {
                                                execute.setEnabled(true);
                                            }
                                        }
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                    worker.execute();
                }
            });

            add(execute, BorderLayout.SOUTH);
        }

    }

    public static class CommandWorker extends SwingWorker<List<String>, String> {

        private JTextArea ta;
        private List<String> commands;

        public CommandWorker(JTextArea ta, List<String> commands) {
            this.ta = ta;
            this.commands = commands;
        }

        public CommandWorker(JTextArea ta, String... commands) {
            this(ta, Arrays.asList(commands));
        }

        @Override
        protected List<String> doInBackground() throws Exception {
            List<String> output = new ArrayList<>(25);
            ProcessBuilder builder = new ProcessBuilder(commands);
            builder.redirectErrorStream(true);

            Process p = builder.start();
            try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line = null;
                while ((line = r.readLine()) != null) {
                    output.add(line);
                    publish(line);
                }
            }
            return output;
        }

        @Override
        protected void process(List<String> chunks) {
            for (String text : chunks) {
                ta.append(text);
                ta.append("\n");
            }
        }

    }

}