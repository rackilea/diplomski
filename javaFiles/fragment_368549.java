public Drawable getThumb(int progress) {
    int width = getWidth();

    ((TextView) mThumbView.findViewById(R.id.tvProgress)).setText(String.format(Locale.getDefault(), "%d%%", progress));
    mThumbView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
    Bitmap bitmap = Bitmap.createBitmap(mThumbView.getMeasuredWidth(), mThumbView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    mThumbView.layout(0, 0, mThumbView.getMeasuredWidth(), mThumbView.getMeasuredHeight());
    mThumbView.draw(canvas);
    return new BitmapDrawable(getResources(), bitmap);
}