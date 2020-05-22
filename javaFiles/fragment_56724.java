Bitmap bmap = Bitmap.createBitmap(imageView.getDrawingCache());
ByteArrayOutputStream stream = new ByteArrayOutputStream();
bmap.compress(Bitmap.CompressFormat.PNG, 50, stream );
byte[] bytes = stream .toByteArray();                               
Intent i = new Intent(this, newActivity.class);
i.putExtra("BMP",bytes);
startActivity(i);