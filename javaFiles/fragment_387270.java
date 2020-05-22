public static String encodeTobase64(Bitmap image) {
    Bitmap immagex=image;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    immagex.compress(Bitmap.CompressFormat.JPEG, 90, baos);
    byte[] b = baos.toByteArray();
    String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
    // Log.e("LOOK", imageEncoded);
    return imageEncoded;
}

public static Bitmap decodeBase64(String input) {
    byte[] decodedByte = Base64.decode(input, 0);
    return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
}