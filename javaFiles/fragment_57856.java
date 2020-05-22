MoveClass newMoveClass = new MoveClass();

do{ 

     newMoveClass.MoveAround();

     newMoveClass.Location();

     System.out.println("move again?");

     answer = replay.next();


   } while(answer.equals("yes"));