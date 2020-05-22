// Any implementation of ImageView can be used!
mImageView = (ImageView) findViewById(R.id.iv_photo);

// Set the Drawable displayed
Drawable bitmap = getResources().getDrawable(R.drawable.wallpaper);
 // or
 // get your bitmap here
mImageView.setImageDrawable(bitmap);

// Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
// (not needed unless you are going to change the drawable later)
mAttacher = new PhotoViewAttacher(mImageView);