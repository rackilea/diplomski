String[] buttonTexts = {"first","second"}; //create the button texts here

//display a modal dialog with your buttons (stops program until user selects a button)
int userDecision =  JOptionPane.showOptionDialog(null,"title","Select a button!",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,buttonTexts,buttonTexts[0]);

//check what button the user selected: stored in the userDecision
// if its the first (left to right) its 0, if its the second then the value is 1 and so on

if(userDecision == 0){
  //first button was clicked, do something
} else if(userDecision == 1) {
  //second button was clicked, do something
} else {
 //user canceled the dialog
}

//display your main JFrame now, according to user input!