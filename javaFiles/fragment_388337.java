// get image from drawable
Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.shyam);

// convert from bitmap to byte array
ByteArrayOutputStream stream = new ByteArrayOutputStream();

bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
byte[] imageInByte = stream.toByteArray();