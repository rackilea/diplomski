public class ProgressPane extends JPanel {

    private JProgressBar progressBar;

    public ProgressPane() {

        setLayout(new GridBagLayout());
        progressBar = new JProgressBar();

        add(progressBar);

    }

    public void doWork() {

        Worker worker = new Worker();
        worker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equals(evt.getPropertyName())) {
                    progressBar.setValue((Integer) evt.getNewValue());
                }
            }

        });

        worker.execute();

    }

}