public AnimationThread() {
   EventQueue.setAnimationCounter(0);
   alive = true;
   new Thread(this, "Animation Thread").start();
}

public static void startAnimation() {
   new AnimationThread();
}