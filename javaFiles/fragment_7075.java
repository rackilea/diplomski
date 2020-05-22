class ActionRollWorker extends SwingWorker<Void, String> {
  public StringdoInBackground() {
    for(int i = 0; i < 3; i++){
      // making instance of generator
      Generator generator = new Generator();

      //get info from generator
      String uitkomst = generator.getResults();
      int isHonderd = generator.getIfHunderd();
      int isMexico = generator.getIfMexico();

      publish(uitkomst);
    }
    return null;
  }

  protected void process( List<String> chunks )
  {
    for( String uitkomst : chunks )
    {
      String[] parts = uitkomst.split("-");
      String dice1 = parts[0];
      String dice2 = parts[1];

      //setLeft Dice
      ImageIcon image = new ImageIcon("img/diceSurface/diceSurface0"+dice1+".png");
      ((IconPanel) pnDiceLeft).setImage(image);

      //setRightDice
      ImageIcon image1 = new ImageIcon("img/diceSurface/diceSurface0"+dice2+".png");
      ((IconPanel) pnDiceRight).setImage(image1);
    }
  }

  protected void done() {
    //nothing
  }
}