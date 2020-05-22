if (file1==true){
    String myJpgPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/01.jpg";
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inSampleSize = 0;
    Bitmap bitmap = BitmapFactory.decodeFile(myJpgPath, options);
    imageView.setImageBitmap(bitmap);
}