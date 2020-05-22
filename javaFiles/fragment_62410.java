DisplayMetrics metrics = new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(metrics); 

// Convert from dots per inch to dots per centimetre.
int xdpc = metrics.xdpi / 2.54; 
int ydpc = metrics.ydpi / 2.54;