ByteArrayOutputStream outStream;
int size = myBitmap.getWidth() * myBitmap.getHeight() * 2;

while (true) {
    outStream = new ByteArrayOutputStream(size);
    if (myBitmap.compress(Bitmap.CompressFormat.PNG, 0, outStream))
        break;
    size = size * 3 / 2;    
}
byte[] buffer = outStream.toByteArray();