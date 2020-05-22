private static final int TAKE_PHOTO_CODE = 1;

private void takePhoto(){
  final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
  intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(getTempFile(this)) ); 
  startActivityForResult(intent, TAKE_PHOTO_CODE);
}

private File getTempFile(Context context){
  //it will return /sdcard/image.tmp
  final File path = new File( Environment.getExternalStorageDirectory(), context.getPackageName() );
  if(!path.exists()){
    path.mkdir();
  }
  return new File(path, "image.tmp");
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  if (resultCode == RESULT_OK) {
    switch(requestCode){
      case TAKE_PHOTO_CODE:
        final File file = getTempFile(this);
        try {
          Bitmap captureBmp = Media.getBitmap(getContentResolver(), Uri.fromFile(file) );
          // do whatever you want with the bitmap (Resize, Rename, Add To Gallery, etc)
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
      break;
    }
  }
}