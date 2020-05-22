progressBar.addMouseListener(new MouseAdapter() {            
    public void mouseClicked(MouseEvent e) {
       int v = progressBar.getValue();
       jlabel.setText("----"+v);

       //Retrieves the mouse position relative to the component origin.
       int mouseX = e.getX();

       //Computes how far along the mouse is relative to the component width then multiply it by the progress bar's maximum value.
       int progressBarVal = (int)Math.round(((double)mouseX / (double)progressBar.getWidth()) * progressBar.getMaximum());

       progressBar.setValue(progressBarVal);
  }                                     
});