private void downloadCoverBackground(FrameLayout coverBackground) {

 ParseUser currentUser = ParseUser.getCurrentUser();

 if (currentUser.getParseFile(ParseConstants.KEY_COVER_BACKGROUND) != null) {

  String coverBackgroundURL = currentUser.getParseFile(ParseConstants.KEY_COVER_BACKGROUND).getUrl();

  // Asynchronously display the cover background image downloaded from Parse
  if (coverBackgroundURL != null) {

   Picasso.with(getApplicationContext())
    .load(coverBackgroundURL)
    //.networkPolicy(NetworkPolicy.OFFLINE)
    .placeholder(R.color.placeholderblue)
    .into(new Target() {

     @Override
     public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
       coverBackground.setBackground(new BitmapDrawable(getApplicationContext().getResources(), bitmap));
      }
     }

     @Override
     public void onBitmapFailed(final Drawable errorDrawable) {
      Log.d("TAG", "FAILED");
     }

     @Override
     public void onPrepareLoad(final Drawable placeHolderDrawable) {
      Log.d("TAG", "Prepare Load");
     }
    });

  } else {
   coverBackground.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.stroke));
  }
 } else {
  coverBackground.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.stroke));
 }

}