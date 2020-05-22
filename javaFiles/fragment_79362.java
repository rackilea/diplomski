import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;
import javax.swing.*;

@SuppressWarnings("serial")
public class Minimo2 extends JPanel {
    private static final int EB_GAP = 15;
    private static final int PROG_BAR_WDTH = 400;
    public static final int MAX_DATA = 15;
    private JProgressBar progresso;
    private JLabel lblProgresso;
    private JButton jButton1;
    private Action importDataAction = new ImportDataAction("Import Data");

    public Minimo2() {
        initComponents();
    }

    private void initComponents() {
        progresso = new JProgressBar(0, MAX_DATA);
        lblProgresso = new JLabel(" ");
        jButton1 = new JButton(importDataAction);
        int progBarHeight = progresso.getPreferredSize().height;
        progresso.setPreferredSize(new Dimension(PROG_BAR_WDTH, progBarHeight));
        progresso.setStringPainted(true);

        JPanel btnPanel = new JPanel();
        btnPanel.add(jButton1);
        JPanel labelPanel = new JPanel();
        labelPanel.add(lblProgresso);
        JPanel progressPanel = new JPanel();
        progressPanel.add(progresso);

        setBorder(BorderFactory.createEmptyBorder(EB_GAP, EB_GAP, EB_GAP, EB_GAP));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(btnPanel);
        add(Box.createVerticalStrut(EB_GAP));
        add(labelPanel);
        add(Box.createVerticalStrut(EB_GAP));
        add(progressPanel);
    }

    private class ImportDataAction extends AbstractAction {
        public ImportDataAction(String name) {
            super(name); // give the button text
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic); // give it a hot key
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setEnabled(false); // disable our button
            ImportDataWorker worker = new ImportDataWorker(MAX_DATA);
            worker.addPropertyChangeListener(new WorkerListener());
            worker.execute();
        }
    }

    private class WorkerListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName())) {
                int progValue = (int) evt.getNewValue();
                progresso.setValue(progValue);
                String text = String.format("%02d/15", progValue);
                lblProgresso.setText(text);
            } else if ("state".equals(evt.getPropertyName())) {
                if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                    @SuppressWarnings("rawtypes")
                    SwingWorker worker = (SwingWorker)evt.getSource();
                    try {
                        worker.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    progresso.setValue(MAX_DATA);
                    String text = String.format("%02d/15", MAX_DATA);
                    lblProgresso.setText(text);
                    importDataAction.setEnabled(true);
                }
            }
        }
    }

    private class ImportDataWorker extends SwingWorker<Void, Void> {

        private static final long SLEEP_TIME = 500;
        private int max;

        public ImportDataWorker(int max) {
            this.max = max;
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i < max; i++) {                
                setProgress(i);
                Thread.sleep(SLEEP_TIME);
            }
            return null;
        }

    }

    private static void createAndShowGui() {
        Minimo2 mainPanel = new Minimo2();

        JFrame frame = new JFrame("Minimo2");
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