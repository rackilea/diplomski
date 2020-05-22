private void loadImage(String imagePath) {
    Uri imageUri;
    String fullImagePath;
    Drawable image;
    ImageView imageDisplay;

    imageUri = Uri.parse(imagePath);
    fullImagePath = imageUri.getPath();
    image = Drawable.createFromPath(fullImagePath);

    imageDisplay = (ImageView) findViewById(R.id.imageDisplay);
    /*if image is null after Drawable.createFromPath, this will simply
      clear the ImageView's background */
    imageDisplay.setImageDrawable(image);

    /*if you want the image in the background instead of the foreground,
      comment the line above and uncomment this bit instead */
    //imageDisplay.setBackground(image);
}