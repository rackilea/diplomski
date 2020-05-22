public static Bitmap viewToBitmap(Activity activity, Bitmap bitmap, String mapURL, String latLong, String dateTime) {

    try {

        AsyncTask asyncTask = new BackgroundUtils.setImageFromUrl().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, mapURL);
        Bitmap googleBitmap = (Bitmap) asyncTask.get();

        Bitmap.Config bitmapConfig = bitmap.getConfig();

        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }

        Bitmap bmp = bitmap.copy(bitmapConfig, true);
        Canvas canvas = new Canvas(bmp);
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewGroup root = (ViewGroup) activity.findViewById(R.id.relativeLayout);
        View layout = inflater.inflate(R.layout.screenshot_content, root, false);
        ImageView cameraView = (ImageView) layout.findViewById(R.id.cameraView);
        ImageView mapView = (ImageView) layout.findViewById(R.id.mapView);
        TextView latLongView = (TextView) layout.findViewById(R.id.latLongView);
        TextView dateTimeView = (TextView) layout.findViewById(R.id.dateTimeView);

        cameraView.setImageBitmap(bitmap);
        mapView.setImageBitmap(googleBitmap);
        latLongView.setText(latLong);
        dateTimeView.setText(dateTime);

        layout.setDrawingCacheEnabled(true);
        layout.measure(View.MeasureSpec.makeMeasureSpec(canvas.getWidth(), View.MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(canvas.getHeight(), View.MeasureSpec.EXACTLY));
        layout.layout(0, 0, layout.getMeasuredWidth(), layout.getMeasuredHeight());
        layout.draw(canvas);

        return bmp;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;

}