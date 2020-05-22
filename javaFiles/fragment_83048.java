private static void translateView(View view, int translationY)
{
    ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", translationY);
    animator.setDuration(1000);
    animator.start();
}