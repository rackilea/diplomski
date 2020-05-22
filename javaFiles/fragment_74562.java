public class Drawing extends Activity implements OnTouchListener{

    DrawPanel dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        dp = new DrawPanel(this);
        dp.setOnTouchListener(this);
            // do other stuff you want
            setContentView(dp);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        dp.pause();
    }



    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        dp.resume();
    }

    public class DrawPanel extends SurfaceView implements Runnable{

        Thread t = null;
        SurfaceHolder holder;
        boolean isItOk = false ;

        public DrawPanel(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
            holder = getHolder();
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while( isItOk == true){

                if(!holder.getSurface().isValid()){
                    continue;
                }

                Canvas c = holder.lockCanvas();
                c.drawARGB(255, 0, 0, 0);
                onDraw(c);
                holder.unlockCanvasAndPost(c);
            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // TODO Auto-generated method stub
            super.onDraw(canvas);
                    // do your drawing stuff here
            }
        }

        public void pause(){
            isItOk = false;
            while(true){
                try{
                    t.join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                break;
            }
            t = null;
        }

        public void resume(){
            isItOk = true;  
            t = new Thread(this);
            t.start();

        }




    }


    @Override
    public boolean onTouch(View v, MotionEvent me) {
    // capture your coordinates here         
    return true;

    }


}