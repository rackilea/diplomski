SwingWorker worker = new SwingWorker<Void, Void>() {
    @Override
    public Void doInBackground() {
        FileConverter fc = new FileConverter();
        return null;
    }

    @Override
    public void done() {
        JOptionPane.showMessageDialog(this, "Step 1 Complete!", "Validation", JOptionPane.INFORMATION_MESSAGE);
    }
};