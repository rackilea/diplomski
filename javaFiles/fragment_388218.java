public void moveJet2() throws IOException{
 int gameAction = getKeyStates();

 if((gameAction & LEFT_PRESSED)!=0) {
  padX -= padXVel;
 }
 if((gameAction & RIGHT_PRESSED)!=0) {
  padX += padXVel;
 }
 if((gameAction & UP_PRESSED)!=0) {
  padY-=padYVel;
 }
 if((gameAction & DOWN_PRESSED)!=0){
  padY+=padYVel;
 }            
}