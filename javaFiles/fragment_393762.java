File ifile = new  File(“PATH/anyPngYouWant.png”);
if(ifile.exists()){

    Bitmap bmp = BitmapFactory.decodeFile(ifile.getAbsolutePath());

    ImageView iv = (ImageView) findViewById(R.id.imageView1);
    iv.setImageBitmap(bmp);

}