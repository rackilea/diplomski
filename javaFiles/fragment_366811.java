class Action implements ActionListener{ 
 private JButton button;
 public Action(JButton button){ 
  this.button = button; 
 } 
 public void actionPerformed(ActionEvent e) { 
   button.setText(letter); 
   button.setEnabled(false); 
   counter++; 
   boolean gameOver = checkForWinners(); 
   if(!gameOver) 
    changeTurn(); 
   else{ 
    newgame.setText("Play again?"); 
    newgame.addActionListener(resetButton); 
   } 
 } 
}