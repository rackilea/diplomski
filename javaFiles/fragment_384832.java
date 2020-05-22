private boolean doubleBackToExitPressedOnce = false;
private Handler handler;
private Runnable runnable;

@Override
public void onBackPressed() {
    if (MENU.getVisibility() == View.VISIBLE) {
        MENU.setVisibility(View.INVISIBLE);
        menuActual.setVisibility(View.INVISIBLE);
        return;
    }

    if (!doubleBackToExitPressedOnce) {
        doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tap again to Exit!", Toast.LENGTH_SHORT).show();

        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
        return;
    }

    // Removes the callBack
    handler.removeCallbacks(runnable);

    // Replace this next line with finishAffinity() if you want to close the app.
    super.onBackPressed();
}