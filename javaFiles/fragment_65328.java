LinearLayout ll = (LinearLayout) findViewById(R.id.root);

try {
    ImageView image = new ImageView(this);
    Bitmap bitmap = BitmapFactory.decodeStream(getAssets().open("tag-logo-android.png"));
    image.setImageBitmap(bitmap);
    ll.addView(image);

    image = new ImageView(this);
    bitmap = BitmapFactory.decodeStream(new URL("http://cdn.sstatic.net/stackoverflow/img/tag-logo-android.png").openStream());
    image.setImageBitmap(bitmap);
    ll.addView(image);
} catch (MalformedURLException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}