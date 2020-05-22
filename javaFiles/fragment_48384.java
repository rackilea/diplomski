public static final int DIALOG2_DELAY_SECS = 4;

public static void execute(final MainActivity activity) {
    Rooted.rooted(activity);
    final AlertDialog alertDialog2 = new AlertDialog.Builder(this).create();
    alertDialog2.setTitle("Executing");
    alertDialog2.setMessage("Your phone will now reboot");
    alertDialog2.setOnShowListener(new AlertDialog.OnShowListener() {
        @Override
        public void onShow(DialogInterface dialog) {
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    runmods(activity);
                }
            }, DIALOG2_DELAY_SECS*1000);
        }
    });
    AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
    alertDialog.setTitle("Confirm");
    alertDialog.setMessage("Are you sure you want to execute and reboot?");
    alertDialog.setButton("Yes", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            alertDialog2.show();
        }
    });
    alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
        }
    });
    alertDialog.show();
}