Picasso.with(getActivity()).load(R.drawable.table_background).into(new Target(){

  @Override
  public void onBitmapLoaded(Bitmap bitmap, LoadedFrom from) {
     mainLayout.setBackground(new BitmapDrawable(context.getResources(), bitmap));
  }

  @Override
  public void onBitmapFailed(final Drawable errorDrawable) {
      Log.d("TAG", "FAILED");
  }

  @Override
  public void onPrepareLoad(final Drawable placeHolderDrawable) {
      Log.d("TAG", "Prepare Load");
  }      
})