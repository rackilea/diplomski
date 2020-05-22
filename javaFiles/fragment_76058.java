Timer timer = new Timer( 500, new ActionListener(){
  @Override
  public void actionPerformed( ActionEvent e ){
    //toggle visible flag of the shape
    //trigger a repaint
  }
} );
timer.setRepeats( true );
timer.start();