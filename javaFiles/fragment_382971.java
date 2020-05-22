private Bitmap getCroppedBitmap(boolean isSelected){
     Bitmap fullImage = BitmapFactory.decodeResource(getResources(), R.drawable.sprite);
     Bitmap piece = null;
     int height = fullImage.getHeight()/2;
     if(isSelected){
         // show first image
         piece = Bitmap.createBitmap(fullImage, 0, 0, fullImage.getWidth(), height);
     }else{
         // show second image
         piece = Bitmap.createBitmap(fullImage, 0, height, fullImage.getWidth(), height);
     }
     return piece;
    }