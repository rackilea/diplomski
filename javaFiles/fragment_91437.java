if(android.os.Build.VERSION.SDK_INT >= 11){
    // will update the "progress" propriety of seekbar until it reaches progress
    ObjectAnimator animation = ObjectAnimator.ofInt(seekbar, "progress", progress); 
    animation.setDuration(500); // 0.5 second
    animation.setInterpolator(new DecelerateInterpolator());
    animation.start();
}
else 
    seekbar.setProgress(progress); // no animation on Gingerbread or lower