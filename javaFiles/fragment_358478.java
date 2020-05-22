public String getStringImage(Bitmap bmp)
{
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
    byte[] imageBytes = baos.toByteArray();
    String input = Base64.encodeToString(imageBytes, Base64.DEFAULT);
    return input;
}

public void decodeImage(ImageView iv, String input)
{
    byte[] decodedByte = Base64.decode(input, Base64.DEFAULT);
    Bitmap bitmap = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    iv.setImageBitmap(bitmap);
}