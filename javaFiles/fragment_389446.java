@Override
public void onDestroy () {
    if (anim1 !=null && run1 !=null) {
    anim1.removeCallbacks(run1);
    super.onDestroy ();
    }
}