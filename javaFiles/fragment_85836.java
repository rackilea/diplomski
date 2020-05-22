import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestSwingWorkerGui extends JPanel {
    private JProgressBar progressBar = new JProgressBar(0, 100);
    private Action myAction = new MyAction("Do It!");

    public TestSwingWorkerGui() {
        progressBar.setStringPainted(true); 
        add(progressBar);
        add(new JButton(myAction));
    }

    private class MyAction extends AbstractAction {
        public MyAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            myAction.setEnabled(false);
            Task read = new Task(30) {
                @Override
                public String doInBackground() throws Exception {
                    int counter = getCounter();
                    int max = getMax();
                    while (counter < max) {
                        counter = getCounter();
                        step();
                        TimeUnit.MILLISECONDS.sleep(200);
                    }
                    return "Worker is Done";
                }
            };
            read.addPropertyChangeListener(new MyPropListener());
            read.execute();
        }
    }

    private class MyPropListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            String name = evt.getPropertyName();
            if ("progress".equals(name)) {
                progressBar.setIndeterminate(false);
                progressBar.setValue((Integer) evt.getNewValue());
            } else if ("state".equals(name)) {
                if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                    myAction.setEnabled(true);
                    @SuppressWarnings("unchecked")
                    SwingWorker<String, Void> worker = (SwingWorker<String, Void>) evt.getSource();
                    try {
                        String text = worker.get();
                        System.out.println("worker returns: " + text);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void createAndShowGui() {
        TestSwingWorkerGui mainPanel = new TestSwingWorkerGui();

        JFrame frame = new JFrame("GUI");
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