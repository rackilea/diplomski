if(!empty) {
   gameOver = true;
   textView.setText("Game Over. Draft!");

   for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++)
                b[i][j].setClickable(false); // button object
   } 
}