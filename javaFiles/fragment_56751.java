public abstarct class Level2(){

 //The game was into a panel like your.
 //Here i added .setFocusable and .addKeyListener to panel

  //Here it was an
  public void actionListener(){
      //The actionListener checked if the player found the door(for next level)


  //Here it was the repaint so every time something happened repaint()


   repaint();
  }//End of Action Listener


 //Use the paint or paintComponent what you need..
  public void paint[or paintComponent](Graphics g){

      //the 'squares' and the icons the had to be *repainted* again
  }



 //Here i had an extra class into this for the KeyListeners
 //And I added the KeyListener like your game(up,down,left,right)
 //I i said before i added this KeyListener to the panel
    private class TAdapter extends KeyAdapter {
        //KeyPressed,Released...etc
    }
  }