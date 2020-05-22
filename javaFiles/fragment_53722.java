public void getCellLength(Context context){
    DisplayMetrics metrics = context.getResources().getDisplayMetrics();
    int width = metrics.widthPixels;
    int height = metrics.heightPixels;
    int length = Math.min(width,height)/6;
}