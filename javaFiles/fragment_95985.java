public class OurView extends SurfaceView implements Runnable
    {
        Thread t=null;
        SurfaceHolder holder;
        boolean ok;

        public OurView(Context context)
        {
            super(context);
            holder=getHolder();

        }
        public void run()
        {
                  //draw the bitmaps
                } 
            public void pause()
        {
            ok=false;
            Log.v("pause()", "ok=false");
            while(true)
            {
                try{

                    t.join();

                }
                catch(InterruptedException e)
                {
                    Log.v("pause()",e.toString());
                }

                break;
            }
           t=null;

        }
        public void resume()
        {
            ok=true;
            if(t==null)
            {
             t=new Thread(this);
               t.start();
               Log.v("resume()", "new thread started");
            }
            else
            {
                Log.v("resume()", "new thread not started as t!=null");
            }
        }
}