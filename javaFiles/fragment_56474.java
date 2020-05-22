titleTv.setText(title);
contentTv.setText(content);
try {
  //where imageUrl is what you pulled out from the rss feed
  Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageUrl).getContent());
  image.setImageBitmap(bitmap); 
} catch (MalformedURLException e) {
 //log exception here
} catch (IOException e) {
  //log exception here
}