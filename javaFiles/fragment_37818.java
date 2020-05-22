private ImageView generateImageView() {
  ImageView myImage = new ImageView(this);

  // set the ImageView properties here.
  ...

  return myImage;
} 

private void addImageViewToList(ImageView imageView) {
  // Add ImageView to the array
}

// hold previous click listener for ImageView.
private View.OnClickListener mImageViewClickListener;

// Get View.OnClickListener for ImageView, create it if not yet initialized.
private View.OnClickListener getImageViewClickListener() {
  if(mImageViewClickListener == null) {
     mImageViewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
          // handle the ImageView click here
          ...
        }
  }
  return mImageViewClickListener;
}