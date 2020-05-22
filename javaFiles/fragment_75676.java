// create Intent to take a picture and return control to the calling application
Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

// start the image capture Intent
startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);