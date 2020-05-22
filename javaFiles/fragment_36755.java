final JDialog dialog = new JDialog(GUI.this, "In progress", true);
JProgressBar progressBar = new JProgressBar(0, 100);
progressBar.setIndeterminate(true);
dialog.getContentPane().add(BorderLayout.CENTER, progressBar);
dialog.getContentPane().add(BorderLayout.NORTH, new JLabel("Elaborating strings..."));
dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
dialog.setSize(300, 75);
dialog.setLocationRelativeTo(GUI.this);
lista.clear();
SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {

    @Override
    public Void doInBackground() throws Exception {
        // all called *off* the event thread
        lista = loadFile.openFile(file);
        for (int i = 0; i < lista.size(); i++) {
            publish(lista.get(i));
        }
        return null;
    }

    @Override
    protected void process(List<String> chunks) {
        // called on the event thread
        for (String chunk : chunks) {
            textArea.append(chunk + "\n");
        }
    }

    // called on the event thread
    public void done() {
        dialog.setVisible(false);
        // should call get() here to catch and handle
        // any exceptions that the worker might have thrown
    }
};
worker.execute();
dialog.setVisible(true); // call this last since dialog is modal