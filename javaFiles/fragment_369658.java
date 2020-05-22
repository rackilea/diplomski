import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

@SuppressWarnings("serial")
public class JavaTest2 extends JPanel {
    private static final int W = 800;
    private static final int H = 260;
    private Action doTestAction = new DoTestAction("Do Test");
    private JProgressBar progressBar = new JProgressBar(0, 100);
    private MyClockPanel clockPanel = new MyClockPanel();
    private MyTimerPanel timerPanel = new MyTimerPanel();

    public JavaTest2() {
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 35, 5));
        topPanel.add(new JButton(doTestAction));

        progressBar.setStringPainted(true);
        JPanel progressPanel = new JPanel(new GridBagLayout());
        progressPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        progressPanel.add(progressBar, gbc);

        JLabel progressLabel = new JLabel("Progress", SwingConstants.CENTER);
        progressLabel.setFont(new Font("Times New Roman", 0, 20));
        progressLabel.setForeground(new Color(8, 68, 128));

        JPanel centralPanel = new JPanel(new BorderLayout(5, 5));
        centralPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        centralPanel.add(progressLabel, BorderLayout.PAGE_START);
        centralPanel.add(progressPanel);

        JPanel clockWrapper = new JPanel();
        clockWrapper.add(clockPanel);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
        bottomPanel.add(timerPanel, BorderLayout.PAGE_START);
        bottomPanel.add(clockWrapper, BorderLayout.PAGE_END);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(topPanel, BorderLayout.PAGE_START);
        add(bottomPanel, BorderLayout.PAGE_END);
        add(centralPanel);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension superSize = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSize;
        } else {
            int w = Math.max(superSize.width, W);
            int h = Math.max(superSize.height, H);
            return new Dimension(w, h);
        }
    }

    private class DoTestAction extends AbstractAction {
        private MyWorker myWorker = null;

        public DoTestAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (myWorker != null && myWorker.getState() == SwingWorker.StateValue.STARTED) {
                return; // still running
            }
            timerPanel.start();
            progressBar.setValue(0);
            myWorker = new MyWorker();
            myWorker.addPropertyChangeListener(new WorkerListener());
            myWorker.execute();
            setEnabled(false);
        }
    }

    class WorkerListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            // if the worker is changing its progress bound property:
            if (evt.getPropertyName().equals("progress")) {
                int progress = (int) evt.getNewValue();
                // just for safety's sake, limit progress to 100 and no more
                progress = Math.min(progress, 100);
                progressBar.setValue(progress);
            } else if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                // else if worker is done
                try {
                    // get the result to at least trap errors
                    String result = ((MyWorker) evt.getSource()).get();
                    // can display result in the GUI
                    timerPanel.stop();
                } catch (Exception e) {
                    // worker's exception is available to the GUI if desired here
                    e.printStackTrace();
                }
                progressBar.setValue(100);
                doTestAction.setEnabled(true);
            }
        }
    }

    private static class MyWorker extends SwingWorker<String, Void> {
        private static final int EXECUTOR_COUNT = 12;
        private static final int TASK_COUNT = 222;

        @Override
        protected String doInBackground() throws Exception {
            ExecutorService executor = new ThreadPoolExecutor(EXECUTOR_COUNT, EXECUTOR_COUNT * 2, 1,
                    TimeUnit.SECONDS, new LinkedBlockingQueue<>());
            List<Future<String>> futures = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < TASK_COUNT; i++) {
                Callable<String> aRunner = new ARunner();
                futures.add(executor.submit(aRunner));
            }
            executor.shutdown();
            int index = 0;
            for (Future<String> future : futures) {
                String result = future.get();
                sb.append(result);
                sb.append(" ");
                index++;
                int progress = (100 * index) / TASK_COUNT;
                progress = Math.min(progress, 100);
                setProgress(progress);
            }

            return sb.toString();
        }
    }

    private static class ARunner implements Callable<String> {
        private static final long SLEEP_TIME = 800;

        @Override
        public String call() throws Exception {
            TimeUnit.MILLISECONDS.sleep(SLEEP_TIME);
            return "Foo";
        }
    }

    private static void createAndShowGui() {
        JavaTest2 mainPanel = new JavaTest2();

        JFrame frame = new JFrame("Java Test 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}