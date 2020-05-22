class ClicksReporter implements ActionListener {
  long startTime=0;
  @Override
  public void actionPerformed(ActionEvent e) {
  if ( e.getActionCommand().equals("ButtonA") ) {
    System.out.println("ButtonA was clicked");
    this.startTime = System.currentTimeMillis()/1000;
  } 

  if ( e.getActionCommand().equals("ButtonB") ) {
    System.out.println("ButtonB was clicked");
    long endTime = System.currentTimeMillis()/1000 - startTime;
    System.out.println("Time: "+endTime);    
  }
}