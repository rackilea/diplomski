public void keyPressed(KeyEvent ae){
   char keyChar = ae.getKeyChar();
   if (keyChar == 'a' ) {
      selection = 1;
   } else {
      selection = 2;
   }

   repaint();
}