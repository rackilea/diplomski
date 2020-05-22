private void addNewImage(double X, double Y) {
    ImageView img = new ImageView(this);
    img.setImageResource(R.drawable.yourimage);
    myView.addView(img);
    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) img.getLayoutParams();
    lParams.leftMargin = (int)X;
    lParams.topMargin = (int)Y;
    img.setLayoutParams(lParams);
}