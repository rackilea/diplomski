@Override
public void onCreate(final Bundle savedInstanceState) {
    // your code

    new AlertDialog.Builder(this)  
       .setMessage("Your network is disabled, enable now?")  
       .setTitle("Alert")  
       .setCancelable(false)
       .setPositiveButton(android.R.string.ok, 
           new DialogInterface.OnClickListener() {  
               public void onClick(DialogInterface dialog, int whichButton) {
                   // launch settings
                   Intent settings = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                   startActivity(settings);
               }  
           })
       .setNegativeButton(android.R.string.cancel,
           new DialogInterface.OnClickListener() {  
               public void onClick(DialogInterface dialog, int whichButton) {
                   dialog.dismiss();

                   // finish activity
                   finish();
               }  
           })
       .show();
}