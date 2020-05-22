private class HandlerClass implements ActionListener{
  private boolean isClicked = true;
  public void actionPerformed(ActionEvent event){
    if(isClicked){
        title1.setText("Do you know the title of the book?");
        /** TODO uncomment here
        if(item3.equals(event.getSource())
          System.out.println("item3 pressed");
        else
          System.out.println("item4 pressed");
        //*/
    } else {...