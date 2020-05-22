private Runnable r;  // assign before use
private Handler h;   // assign before use

private void schedule() {
    h.postDelayed(r, 99999);
}

private void cancel() {
    h.removeCallbacks(r);
}