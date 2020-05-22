Final Thread t = new Thread(new Runnable(){
       @Override public void run(){
          while(!t.isInterrupted(){
             setTempo(mTempo++);
          }
       }
switch (event){
case ACTION_DOWN: 
       t.start();
       break;
case ACTION_UP:
       t.interrupt();
       break
}