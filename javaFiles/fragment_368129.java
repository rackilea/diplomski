if (items[which].equals("Picture")) {
   Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

   File imagesFolder = new File(Environment.getExternalStorageDirectory(),
        "SecExPhotos");
   imagesFolder.mkdirs(); // <----
   File image = new File(imagesFolder, "image_001.jpg");
   Uri uriSavedImage = Uri.fromFile(image);
   cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,uriSavedImage);
   startActivityForResult(cameraIntent,PICTURE_ACTIVITY);
}