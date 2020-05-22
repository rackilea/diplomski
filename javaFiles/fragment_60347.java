private boolean hasButtonOneBeenPressed = false; //set this to true when the button has been clicked

public void actionPerformed(ActionEvent e){
  if (Integer.parseInt(e.getActionCommand()) == 0 && !hasButtonOneBeenPressed){
    System.out.println("This is Jug 0");
    // wont be able to print the following
  } else if(Integer.parseInt(e.getActionCommand()) == 1 && hasButtonOneBeenPressed){
      System.out.println("This is Jug 1 AFTER jug 0");
    } else {
      //do something else
   }
}