final AlertDialog.Builder dialog = new AlertDialog.Builder(this).setTitle("Leaving launcher").setMessage("Are you sure you want to leave the launcher?");
dialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int whichButton) {
        exitLauncher();
    }
});     
final AlertDialog alert = dialog.create();
alert.show();

// Hide after some seconds
final Handler handler  = new Handler();
final Runnable runnable = new Runnable() {
    @Override
    public void run() {
        if (alert.isShowing()) {
            alert.dismiss();
        }
    }
};

alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
    @Override
    public void onDismiss(DialogInterface dialog) {
        handler.removeCallbacks(runnable);
    }
});

handler.postDelayed(runnable, 10000);