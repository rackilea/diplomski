public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
Drawable drawable = ContextCompat.getDrawable(context, drawableId);
if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
    drawable = (DrawableCompat.wrap(drawable)).mutate();
}

Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
        drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
Canvas canvas = new Canvas(bitmap);
drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
drawable.draw(canvas);

return bitmap;
}