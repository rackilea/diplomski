public void switchContent(final Fragment fragment) {
    mContent = fragment;
    getSupportFragmentManager()
    .beginTransaction()
    .replace(R.id.content_frame, fragment)
    .commit();
    Handler h = new Handler();
    h.postDelayed(new Runnable() {
        public void run() {
            sm.showContent();
        }
    }, 50);
}