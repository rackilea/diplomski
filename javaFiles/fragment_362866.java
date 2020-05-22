cropIwaView.setCropSaveCompleteListener(bitmapUri -> {
  addPicToGallery(context, bitmapUri); // sendBroadcast to gallery to scan new added images...
 });

cropIwaView.crop(new CropIwaSaveConfig.Builder(imageUri)
                .setCompressFormat(Bitmap.CompressFormat.PNG)
                .setQuality(100) //Hint for lossy compression formats
                .build());