String FOLDER = "YOUR_FOLDER";
String FILENAME = "YOUR_FILENAME";
int TAKE_PHOTO_REQUEST_CODE = 0;
File photoFile;

void TakePhoto()
{
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    photoFile = new File(FOLDER , FILENAME );
    Uri pictureFileUri = Uri.fromFile(photoFile);
    takePictureIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, pictureFileUri);
    startActivityForResult(takePictureIntent, TAKE_PHOTO_REQUEST_CODE);

}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) 
{
    super.onActivityResult(requestCode, resultCode, data); 

    switch(requestCode) { 
    case TAKE_PHOTO_REQUEST_CODE:
        if(resultCode == RESULT_OK)
        {   
            int orientation = 0;
            try
            {
                ExifInterface exif = new ExifInterface(path);
                int exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);
                switch (exifOrientation)
                {
                case ExifInterface.ORIENTATION_NORMAL:
                    orientation = 0;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    orientation = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    orientation = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    orientation = -90;
                    break;
                }
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // Here you can rotate the bitmap knowing the orientation of the camera when the photo was taken
    }
 }