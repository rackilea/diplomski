protected boolean keyChar(char character, int status, int time) {
 switch (character) {
  case Characters.ESCAPE:
   if ( browserField.getHistory().canGoBack() ) {
    browserField.back();
   } else {
    close();
   }
   return true;
  default:
   return super.keyChar(character, status, time);
 }
}