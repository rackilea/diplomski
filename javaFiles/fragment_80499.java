ByteArrayOutputStream stream = new ByteArrayOutputStream();
currentImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
BitmapDataObject bitmapDataObject = new BitmapDataObject();
bitmapDataObject.serializedBitmap = stream.toByteArray();
bitmapDataObject.serializedBitmap  = "";//your string value
out.writeObject(bitmapDataObject);