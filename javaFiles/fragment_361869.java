public class TestView extends SurfaceView
{
     private long totalElapsedTime = 0;
    private Rect[] rectArray;
    private int rectCount = 0;
    private Paint p;
    private GameLoopThread gameLoopThread;

    public TestView(Context context)
    {
        super(context);

       rectArray = shapes.getRectArray();

        p = new Paint();
        p.setColor(Color.BLACK);
        p.setStrokeWidth(10)

       gameLoopThread = new GameLoopThread(this);
       holder = getHolder();
       holder.addCallback(new SurfaceHolder.Callback()
       {

           @Override
            public void surfaceDestroyed(SurfaceHolder holder)
           {
                boolean retry = true;
                gameLoopThread.setRunning(false);
               while (retry)
               {
                  try
                  {
                     gameLoopThread.join();
                     retry = false;
                  }
                  catch (InterruptedException e)
                 {
                 }
              }
          }

          @Override
           public void surfaceCreated(SurfaceHolder holder)
           {
              gameLoopThread.setRunning(true);
              gameLoopThread.start();
           }

           @Override
           public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
           {
           }
    }



    public void update(long elapsedTime)
    {
        totalElapsedTime += elapsedTime;

        //increase the rectCount every second
        rectCount = totalElapsedTime / 1000;

       if(rectCount > rectArray.length)
       {
          rectCount = rectArray.length;
       }
    }


     @Override
     public void onDraw(Canvas canvas)
     {
        canvas.drawARGB(255, 255, 255, 255);

        //draw my rectangles here
        for(int i = 0; i < rectCount; i++)
        {
            canvas.drawRect(i,p);
        }
     }