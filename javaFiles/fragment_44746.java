DisplayMetrics displayMetrics = new DisplayMetrics();
WindowManager wm = (WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
wm.getDefaultDisplay().getMetrics(displayMetrics);
int maxWidth = displayMetrics.widthPixels;
//Make this percentage whatever you want
float movementPercentage = 0.02
//Will move the object 2 percent up the y axis 
meteorite1.setY(meteorite1.getY() + maxWidth*movementPercentage);