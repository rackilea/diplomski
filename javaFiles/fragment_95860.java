public void actionPerformed(ActionEvent arg0) {
     progressBar.setIndeterminate(true);
     new Thread(new Runnable() {
         @Override
         public void run() {
             // do the long-running work here
             // at the end:
             SwingUtilities.invokeLater(new Runnable() {
                 @Override
                 public void run() {
                     progressBar.setIndeterminate(false);
                 }
             );
         }
     ).start();
}