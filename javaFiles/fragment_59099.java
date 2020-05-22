JasperReportsWorker worker = new JasperReportsWorker();
JDialog dialog = new JDialog();
dialog.setModal(true);
dialog.add(new JLabel("Working..."));
dialog.pack();
dialog.setLocationRelativeTo(null);
worker.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String name = evt.getPropertyName();
        JasperReportsWorker worker = (JasperReportsWorker) evt.getSource();
        if ("state".equalsIgnoreCase(name)) {
            switch (worker.getState()) {
                case DONE:
                    if (dialog != null) {
                        dialog.setVisible(false);
                    }
                    try {
                        JasperReport report = worker.get();
                        JasperPrint jasperprint = JasperFillManager.fillReport(jasperreport, null, con);
                        JasperViewer.viewReport(jasperprint, false);
                    } catch (InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                    }
                    break;
            }
        }
    }
});
worker.execute();
dialog.setVisible(true);