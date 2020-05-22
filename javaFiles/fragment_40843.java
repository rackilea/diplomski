public static void loadAnimations(Activity activity){
    heart_icon = (ImageButton) activity.findViewById(R.id.heart_icon);
    bee_icon = (ImageButton) activity.findViewById(R.id.bee_icon);

    anim_heart = AnimationUtils.loadAnimation(activity, R.anim.heart_anim);
    heart_icon.startAnimation(anim_heart);

    anim_bee = AnimationUtils.loadAnimation(activity, R.anim.bee_anim);
    bee_icon.startAnimation(anim_bee);
}