ValueAnimator anim = ValueAnimator.ofInt(progress, seekBar.getMax());
anim.setDuration(Utility.setAnimationDuration(progress));
anim.addUpdateListener(new AnimatorUpdateListener() 
{
    @Override
    public void onAnimationUpdate(ValueAnimator animation) 
    {
        int animProgress = (Integer) animation.getAnimatedValue();
        seekBar.setProgress(animProgress);
    }
});
anim.addListener(new AnimatorListenerAdapter() 
{
    @Override
    public void onAnimationEnd(Animator animation) 
    {
        // done
        //your stuff goes here
    }
});
anim.start();