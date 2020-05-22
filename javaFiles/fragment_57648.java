private Uri imageUri;

  public void onClick(View arg0) {
    switch (arg0.getId()) {     
      case R.id.btnImageCapture:

    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
    File dir = context.getDir("directory", Context.MODE_PRIVATE);
    File photo = new File(dir,  "Pic.jpg");
    intent.putExtra(MediaStore.EXTRA_OUTPUT,
            Uri.fromFile(photo));
    imageUri = Uri.fromFile(photo);
    startActivityForResult(intent, OPEN_CAMERA);
                    break;
    }
}