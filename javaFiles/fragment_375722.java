if (imageStream != null) {
    Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
    ImageView imageview= (ImageView)dialog.findViewById(R.id.imageview);
    chosenBitmap = yourSelectedImage; 
    Drawable res = new BitmapDrawable(yourSelectedImage);
    imageview.setImageDrawable(res);
}