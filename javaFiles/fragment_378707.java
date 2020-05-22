if (buildpathset == 1) {
   setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
   progress.setVisible(true);

   // create my SwingWorker object
   final SwingWorker<Void, Void> myWorker = new SwingWorker<Void, Void>() {
      protected Void doInBackground() throws Exception {
         // here is my long running task, calling in background
         // thread
         wiredsync();
         return null;
      };
   };

   // this allows me to be notified when the SwingWorker has
   // finished
   myWorker.addPropertyChangeListener(new PropertyChangeListener() {

      @Override
      public void propertyChange(PropertyChangeEvent pcEvt) {
         // if the SwingWorker is done
         if (pcEvt.getNewValue() == SwingWorker.StateValue.DONE) {
            // notify the user
            JOptionPane.showMessageDialog(null, "sync complete. ",
                  null, buildpathset);
            setCursor(Cursor.getDefaultCursor());
            progress.setVisible(false);

            try {
               // one way to catch any errors that occur in
               // SwingWorker
               myWorker.get();
            } catch (InterruptedException | ExecutionException e) {
               e.printStackTrace();
            }

         }
      }
   });
   // run my SwingWorker
   myWorker.execute();
} else {
   // warning in here later - TO Do
}