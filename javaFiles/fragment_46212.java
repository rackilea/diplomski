Intent i = new Intent(
Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

startActivityForResult(i, RESULT_LOAD_IMAGE);


or like this 

String directoryPath = Environment.getExternalStorageDirectory() + "/" + IMAGE_DIRECTORY + "/";