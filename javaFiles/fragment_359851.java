public static int convertDPtoPX(Context context, int dpValue) {

     DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

     return dpValue * displayMetrics.densityDpi;

}