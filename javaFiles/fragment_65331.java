CustomAnimation animation = new CustomAnimation((AnimationDrawable) img.getBackground());
animation.setDuration(5000);
animation.setCallableAfterDelay(new Callable<Void>()
{
     @Override
     public Void call()
     {
        img.setBackgroundResource(R.drawable.imgFinished);
        return null;
     }
});

animation.animate();