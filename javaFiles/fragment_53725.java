// This function is called when you come back to your activity after the intent has finished. Do read android documentation on Google. It will Help
public void onActivityResult(int requestCode, int resultCode, Intent data)
{
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == CAMERA_RESULT) 
    {
        if (resultCode == Activity.RESULT_OK) 
        {
            String galleryImatePath = SD_CARD_TEMP_DIR; // make SD_CARD_TEMP_DIR Global so that you can access it here from camera intent or pass it in put Extra method and retrieve it here
            File f = new File(galleryImatePath);

            try {//This code will rotate your image if you have taken the image by rotating the camera
                        Bitmap cameraBitmap = null;
                        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
                        bmOptions.inJustDecodeBounds = false;
                        bmOptions.inPurgeable = true;
                        bmOptions.inBitmap = cameraBitmap; 
                        bmOptions.inMutable = true; 


                        cameraBitmap = BitmapFactory.decodeFile(galleryImatePath,bmOptions);
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        cameraBitmap.compress(Bitmap.CompressFormat.JPEG, 50, bos);

                        //To Rotate image Code
                            ExifInterface exif = new ExifInterface(galleryImatePath);
                            float rotation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);  
                            System.out.println(rotation);

                        float rotationInDegrees = exifToDegrees(rotation);
                        System.out.println(rotationInDegrees);

                        Matrix matrix = new Matrix();
                        matrix.postRotate(rotationInDegrees);

                        final Bitmap rotatedBitmap = Bitmap.createBitmap(cameraBitmap , 0, 0, cameraBitmap.getWidth(), cameraBitmap.getHeight(), matrix, true);
                        FileOutputStream fos=new FileOutputStream(galleryImatePath);
                        rotatedBitmap.compress(Bitmap.CompressFormat.JPEG, 50, fos);
                        fos.write(bos.toByteArray());
                        cameraBitmap.recycle();
                        System.gc();
                        fos.flush();
                        fos.close();


                        // To set image in imageview in dialog. This code will set your image in a custon dialog box "captiondialog". It will contain a full width and height imageview and two textviews - done and cancel. It is upto u what you want to define in the textview's click listener. For example, you can pass the storing image in database in the "Done" textview and "Cancel" textview will dismiss your captiondialog and you app will return to your activity
                    Capdialog = new Dialog(AddToDo.this,android.R.style.Theme_NoTitleBar_Fullscreen);
                    Capdialog.setContentView(R.layout.captiondialog);
                    Capdialog.setCancelable(false);
                    TextView cancel = (TextView) Capdialog
                            .findViewById(R.id.cancel);
                    TextView done = (TextView) Capdialog.findViewById(R.id.done);
                                                Capdialog.getWindow().setSoftInputMode (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                    ImageView img = (ImageView) Capdialog.findViewById(R.id.image);
                    img.setImageBitmap(rotatedBitmap);
               }
               catch(Exception e){}
      }
 }
}