public static Bitmap loadBitmapFromView(View v) {
    Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);                
    Canvas c = new Canvas(b);
    v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
    v.draw(c);
    return b;
}