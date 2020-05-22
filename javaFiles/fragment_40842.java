public static void loadAnimations(Activity activity){
    anim_heart = AnimationUtils.loadAnimation(activity, R.anim.heart_anim);
    if (heart_icon != null) {
        heart_icon.startAnimation(anim_heart);
    }

    anim_bee = AnimationUtils.loadAnimation(activity, R.anim.bee_anim);
    if (bee_icon != null) {
        bee_icon.startAnimation(anim_bee);
    }
}