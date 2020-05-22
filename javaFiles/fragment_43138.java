private byte[] bitmapToByteArray(Bitmap bit) {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bit.compress(Bitmap.CompressFormat.PNG, 100, stream);
    byte[] byteArray = stream.toByteArray();
    return byteArray;
}