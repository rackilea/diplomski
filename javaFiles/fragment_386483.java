// create explicit intent
Intent intent = new Intent(this, CropImage.class);

// tell CropImage activity to look for image to crop 
String filePath = ...;
intent.putExtra(CropImage.IMAGE_PATH, filePath);

// allow CropImage activity to rescale image
intent.putExtra(CropImage.SCALE, true);

// if the aspect ratio is fixed to ratio 3/2
intent.putExtra(CropImage.ASPECT_X, 3);
intent.putExtra(CropImage.ASPECT_Y, 2);

// start activity CropImage with certain request code and listen
// for result
startActivityForResult(intent, REQUEST_CODE_CROP_IMAGE);