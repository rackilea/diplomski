new Thread(new Runnable() {
        public void run() {
      flag=true;

 while(flag==true){

     if(move.equals("yes")){
        //your code

       move="no";
     }else
      Thread.sleep(20); //Sleep For a While(and then check again)
 }

//That means that your Thread will run all over your game
//until game over (when game over just do the flag=false;)
//and The Thread will stop-exit

    }});