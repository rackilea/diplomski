@Override
public void actionPerformed(ActionEvent e) {
    calculateLbl.setVisible(true);
    new SwingWorker<Void, Void>() {
        public Void doInBackground() throws Exception{
            calculate(); // this is run in a background thread
                         // take care that calculate makes no Swing calls
            return null;
        }

        protected void done() {
            show();  // this is run on the Swing event thread
        }
    }.execute();
}