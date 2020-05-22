URL url = new URL(src);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setDoInput(true);
connection.connect();
InputStream input = connection.getInputStream();
Bitmap myBitmap = BitmapFactory.decodeStream(input);