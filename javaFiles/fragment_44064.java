class GuiWorker extends SwingWorker<Integer, Integer> {
    private JFrame frame = new JFrame();
    private JDialog dialog = new JDialog(frame, "Loadin data", true);
    private JProgressBar progressBar = new JProgressBar();

    private Statistics st = new Statistics();

    public GuiWorker(GraphEditor editor, Statistics st) {
        this.st = st;

        Window mainWindow = SwingUtilities.windowForComponent(editor
                .getGraphComponent().getParent());
        dialog.setSize(400, 200);

        int x = mainWindow.getX() + (mainWindow.getWidth() - dialog.getWidth())
                / 2;
        int y = mainWindow.getY()
                + (mainWindow.getHeight() - dialog.getHeight()) / 2;
        progressBar.setString("Have fun to wait some time...");
        progressBar.setStringPainted(true);
        progressBar.setIndeterminate(true);
        dialog.add(progressBar);
        dialog.setModal(true);
        dialog.setLocation(x, y);
    }

    @Override
    protected Integer doInBackground() throws Exception {
        st.loadInitialData();
        return 0;
    }

    @Override
    protected void done() {
        dialog.setVisible(false);
        JLabel label = new JLabel("Task Complete");
        dialog.getContentPane().remove(progressBar);
        dialog.getContentPane().add(label);
        dialog.getContentPane().validate();
        dialog.setVisible(false);
    }

   public void setVisible(boolean visible) {
        dialog.setVisible(visible);
   }
}