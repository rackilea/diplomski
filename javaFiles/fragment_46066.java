try {
    java.net.URL img_value = new java.net.URL(imageURL);        
    Bitmap mIcon = BitmapFactory
            .decodeStream(img_value.openConnection()
                    .getInputStream());
    if (mIcon != null)
        imgByteArray = encodeToByteArray(mIcon);
} catch (Exception e) {
    e.printStackTrace();
}


public byte[] encodeToByteArray(Bitmap image) {
    Log.d(TAG, "encodeToByteArray");
    Bitmap b= image;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    b.compress(Bitmap.CompressFormat.JPEG, 100, baos);
    byte[] imgByteArray = baos.toByteArray();

    return imgByteArray ;
}