box1.setBackground(Color.yellow);
new Thread(new Runnable(){
   public void run(){
       try{
          Thread.sleep(1000);
       }catch(InterruptedException ex){
          ex.printStackTrace();
       }
       box2.setBackground(Color.red);
   }
}).start();