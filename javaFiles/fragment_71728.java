private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
      JOptionPane messagePane = new JOptionPane(
            "Board was sent for validation check\n Please wait...",
            JOptionPane.INFORMATION_MESSAGE);
      final JDialog dialog = messagePane.createDialog(this, "Board Sent");

      new SwingWorker<Void, Void>() {

         @Override
         protected Void doInBackground() throws Exception {
            // do your background processing here
            // for instance validate your board here

            // mimics a background process that takes 3 seconds
            // you would of course delete this in your actual progam
            Thread.sleep(3000); 

            return null;
         }

         // this is called when background thread above has completed.
         protected void done() {
            dialog.dispose();
         };
      }.execute();

      dialog.setVisible(true);

      JOptionPane.showMessageDialog(this, "Set your move now please",
            "Game started", JOptionPane.INFORMATION_MESSAGE);
   }