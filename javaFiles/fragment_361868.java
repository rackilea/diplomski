public class GameLoopThread extends Thread
{
private TestView view;

private boolean running = false;

public GameLoopThread(TestView view)
{
    this.view = view;
}

public void setRunning(boolean run)
{
running = run;
}

@SuppressLint("WrongCall")
@Override
public void run()
{
    long startTime = System.currentTimeMillis();

    while (running)
    {
        Canvas c = null;

        //call update with the number of milliseconds that have passed since the last loop iteration
        view.update(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();

        try
        {
            c = view.getHolder().lockCanvas();

            synchronized (view.getHolder())
            {
                //call onDraw so my surface draws the rectangles
                view.onDraw(c);
            }
        }
        finally
        {
            if (c != null)
            {
                view.getHolder().unlockCanvasAndPost(c);
            }
        }
    }
}
}