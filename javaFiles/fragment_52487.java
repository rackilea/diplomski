void setUIEnabled(boolean enable) {
   for(Button eachUIButton : getAllClickableButtons()) {
      eachUIButton.setEnabled(enable);
   }
}

void onMouseClick(MouseEvent event) {
   setUIEnabled(false);
   new Thread(
      new Runnable() {
         public void run() {
            final String result = doLengthyProcessing();
            enableRunnable = new Runnable() {
               public void run() {
                  setUIEnabled(true);
                  updateTextLabelFromLengthyProcess(result);
               }
            };
            Swing.invokeLater(enableRunnable);
         }
      }
   ).start();
}