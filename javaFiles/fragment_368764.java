boolean flag=true;
private void Thread_Draw(){

       new Thread(new Runnable(){

            public void run(){

               while(flag)
               {
                    postInvalidate();
                    try{
                       Thread.sleep(45);
                    } catch(InterruptedException e)
                    {
                       e.printStackTrace();
                    }
               }
            }
      }
}