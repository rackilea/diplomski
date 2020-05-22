Bitmap bitmap;

public void displaydata(){
    p = siteDoc.getElementsByTag("p");
    a=p.text();
    String imageUrl = siteDoc.select("img").first().attr("abs:src");
    bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageUrl).getContent());
    uiHandler.post(new Runnable() {
        @Override
        public void run() {
            TextView tv= (TextView) findViewById(R.id.textView);
            tv.setText(a);

            ImageView i = (ImageView)findViewById(R.id.imageView);
            i.setImageBitmap(bitmap);
        }
    });
}