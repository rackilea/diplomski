public static Bitmap LoadBitmap(Context context, String filename){
    AssetManager assets = context.getResources().getAssets();
    InputStream buf = new BufferedInputStream((assets.open("drawable/myimage.png")));
    Bitmap bitmap = BitmapFactory.decodeStream(buf);
    // Drawable d = new BitmapDrawable(bitmap);
    return bitmap;
}