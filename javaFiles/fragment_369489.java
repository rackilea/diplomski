JTextArea textArea = new JTextArea();
JProgressBar progressBar = new JProgressBar(0, 100);
SequentialInvoker task = new SequentialInvoker();
task.addPropertyChangeListener(
    new PropertyChangeListener() {
        public  void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName())) {
                progressBar.setValue((Integer)evt.getNewValue());
            }
        }
    });