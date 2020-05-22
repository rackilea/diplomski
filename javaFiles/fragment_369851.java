private ImageView addImageView(RelativeLayout mainLayout, int x, int y, int width, int height, OnClickListener onClickListener){
    ImageView imageView = new ImageView(this);
    imageView.setAdjustViewBounds(false);
    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    params.height = height;
    params.width = width;
    imageView.setLayoutParams(params);
    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    imageView.setImageDrawable(getResources().getDrawable(R.drawable.marker_red));
    //imageView.setBackgroundColor(Color.BLUE);
    params.leftMargin = x - width/2;
    params.topMargin = y - height/2;
    imageView.setOnClickListener(onClickListener);
    mainLayout.addView(imageView);
    return imageView;
}