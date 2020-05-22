// get screen dimensions
DisplayMetrics displaymetrics = new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
int height = displaymetrics.heightPixels;
int width = displaymetrics.widthPixels;

wpm.suggestDesiredDimensions(width, height);
wpm.setBitmap(dbm);