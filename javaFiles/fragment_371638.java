Runnable doRun = new Runnable() {

   @Override
   public void run() {
      labelResult.setText(eventProcessing.action(isDirect, textField.getText()));
      add(labelResult, BorderLayout.PAGE_END);
      //1) this.pack(); if you want to re-layout with effect to size of JFrame too

      //2a revalidate(); 
      //2b plus in most cases
      //2b repaint(); relayout Container with fitting JComponents inside Container, 
      //2b but without resize of JFrame
   }
};
SwingUtilities.invokeLater(doRun);