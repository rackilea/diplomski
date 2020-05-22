public static boolean checkLegalMove(int[] move, char[][] boardValues){
  if(move[0] > 2 || move[0] < 0 || move[1] > 2 || move[1] < 0){
   return false;
 } 
  if(boardValues[move[0]][move[1]] != ' '){           
    return false;
 }
 return true;
 }

public void doSomething(boolean checkLegalMove(move,boardValues), char player){
 boolean check = checkLegalMove(move,boardValues);
 char temp = player;

if(check ==true ){
 //do something to player
 }else{
  getMove(player);
  }
}