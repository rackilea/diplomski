protected void onActivityResult(int requestCode, int resultCode, Intent ata)                                     
          {
if (requestCode == 0) {
    if (resultCode == RESULT_OK) {

       imv = (ImageView)findViewById(R.id.imv);
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        imv.setImageBitmap(photo);
    }}}