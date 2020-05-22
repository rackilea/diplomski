public void doIt(View view) {

    ImageView imageView = (ImageView) findViewById(R.id.iv);
    Bitmap src = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(src);
    canvas.drawColor(Color.BLUE);//fill src bitmap with blue color
    imageView.setImageBitmap(applyPieMask(src, -90, 60));
}