public void updateProgressBar(int value) {
   progressBar.setValue(value);
}

public void safeUpdateProgressBar(final int value) {
   if (SwingUtilities.isEventDispatchThread()) {
      updateProgressBar(value);
   } else {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            updateProgressBar(value);
         }
      });
   }
}