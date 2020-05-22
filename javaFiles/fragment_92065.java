if (anEvent instanceof KeyEvent) {
   // Get the events key
   int keyCode = ((KeyEvent) anEvent).getKeyCode();
   char keyChar = ((KeyEvent) anEvent).getKeyChar();
   resetText = false;
   // F2 allowed
   if (keyCode == KeyEvent.VK_F2) {
      return true;
   }
   // letters, digits and space allowed
   if (Character.isSpaceChar(keyChar) || Character.isLetterOrDigit(keyChar)) {
      resetText = true;
      return true;
   }
   return false;
}