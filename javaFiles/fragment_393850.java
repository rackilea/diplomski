DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
    screen_width=displayMetrics.widthPixels;    //width of the device screen
    screen_height=displayMetrics.heightPixels;   //height of device screen

     int view_width=screen_width/columns;   //width for text view
     int view_height=screen_height/rows;   //height for text view

     textview.getgetLayoutParams().width=view_width;
     textview.getgetLayoutParams().height=view_height;