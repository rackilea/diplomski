@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) 
     {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_PIC_REQUEST && resultCode == RESULT_OK) {
           Bitmap photo = (Bitmap) data.getExtras().get("data");
           String imgString = toBase64(photo);
          }
     }

public String toBase64(Bitmap bm) {

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
    byte[] b = baos.toByteArray();

    return Base64.encodeToString(b, Base64.NO_WRAP);
}