/**
 * Adds some new features which are not available in the {@link AnimationDrawable} class.
 * The main difference is that this class allows setting a timer, which indicates for how
 * long is the animation supposed to be rendered.
 */
public class CustomAnimation
{
    //==============================================================================================
    private AnimationDrawable animation;

    //==============================================================================================
    private Drawable currentFrame;

    //==============================================================================================
    private Callable<Void> afterDelay;

    //==============================================================================================
    private long lastCheckedTime;
    private long duration;

    //==============================================================================================
    private Runnable animationFinished;
    private Handler handlerAnimation;

    //==============================================================================================
    private boolean infinite;


    /**
     * @param animation the {@link AnimationDrawable} which is about to animate
     */
    public CustomAnimation(AnimationDrawable animation)
    {
        this.animation = animation;
    }

    /**
     * Sets a time limit after which is the animation finished.
     * @param duration time in milliseconds. Set to -1 if the animation is infinite.
     */
    public void setDuration(long duration)
    {
        this.duration = duration;
        if(duration == -1) infinite = true;
    }

    /**
     * Starts the animation from the first frame, looping if necessary.
     */
    public void animate()
    {
        animation.start();
        lastCheckedTime = System.currentTimeMillis();
        stopAfterDelay();
    }

    /**
     * Cancels the animation.
     */
    public void cancel()
    {
        animation.stop();
        if(handlerAnimation != null) handlerAnimation.removeCallbacks(animationFinished);
    }

    /**
     * Pauses the animation.
     */
    public void pause()
    {
        currentFrame = animation.getCurrent();
        duration = getRemainingTime();
        animation.setVisible(false, false);
    }

    /**
     * Pauses the animation.
     * Call this method only in the onPause() callback.
     */
    public void onPause()
    {
        currentFrame = animation.getCurrent();
        duration = getRemainingTime();
        cancel();
    }

    /**
     * Resumes the animation.
     */
    public void resume()
    {
        if(!animation.isRunning())
        {
            lastCheckedTime = System.currentTimeMillis();
            animation.setVisible(true, false);
            setFrame();
            stopAfterDelay();
        }
    }

    /**
     * Resumes the animation.
     * Call this method only in the onResume() callback.
     */
    public void onResume()
    {
        if(!animation.isRunning())
        {
            lastCheckedTime = System.currentTimeMillis();
            animation.start();
            setFrame();
            stopAfterDelay();
        }
    }

    /**
     * Sets the callable method which is called right after the animation finishes.
     * @param afterDelay the callable method which returns nothing
     */
    public void setCallableAfterDelay(Callable<Void> afterDelay)
    {
        this.afterDelay = afterDelay;
    }

    /**
     * @return remaining time in milliseconds until the animation is supposed to be finished
     */
    public long getRemainingTime()
    {
        return duration - (System.currentTimeMillis() - lastCheckedTime);
    }

    private void stopAfterDelay()
    {
        if(infinite) return;

        animationFinished = new Runnable()
        {
            @Override
            public void run()
            {
                animation.stop();

                try { if(afterDelay != null) afterDelay.call(); }
                catch(Exception e) { e.printStackTrace(); }
            }
        };
        handlerAnimation = new Handler();
        handlerAnimation.postDelayed(animationFinished, duration);
    }

    private void setFrame()
    {
        for(int i = 0; i < animation.getNumberOfFrames(); i++)
        {
            Drawable checkFrame = animation.getFrame(i);
            if(checkFrame == currentFrame) break;
            animation.run();
        }
    }
}