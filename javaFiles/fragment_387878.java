public void onMyKeyDown(int key, KeyEvent event){
 //define your statement like
 if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
            && key == KeyEvent.KEYCODE_BACK
            && event.getRepeatCount() == 0) {

     new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Do you really want to Exit?")
                .setIcon(R.drawable.logo)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        finish();

                    }})
                .setNegativeButton(android.R.string.no, null).show();
 }