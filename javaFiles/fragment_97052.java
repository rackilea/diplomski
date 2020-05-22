LayoutInflater inflater = getLayoutInflater();
  View dialoglayout = inflater.inflate(R.layout.dialog_layout, (ViewGroup)     findViewById(R.id.dialog_layout_root));


  //Ask the user if they want to quit
        builder
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setTitle(R.string.quit)
        .setMessage(R.string.really_quit)
        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                //Stop the activity and pause media player
                 mainSound.pause();
                MainActivity.this.finish();    
            }

        })
        .setNegativeButton(R.string.no, null)
        .setView(dailogLayout);





public boolean onKeyDown(int keyCode, KeyEvent event) {
    //Handle the back button
    if(keyCode == KeyEvent.KEYCODE_BACK) {

     builder.show();

        return true;
    }
    else {
        return super.onKeyDown(keyCode, event);
    }

}