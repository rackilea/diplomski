public void LoadImageArray() {
    Bitmap mybitmap;
    LinearLayout layout = (LinearLayout) findViewById(R.id.image_container);
    //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100,100);
    String path= Environment.getExternalStorageDirectory().toString()+"/Pictures";
    File f=new File(path);
    File file[]=f.listFiles();

    for (int i = 0; i < 13; i++) {
         BitmapFactory.Options options = new BitmapFactory.Options();
         options.inJustDecodeBounds = true;
         BitmapFactory.decodeFile(file[i].getAbsolutePath(), options);

        layoutParams.setMargins(1, 1, 1, 1);
        layoutParams.gravity = Gravity.LEFT;
        ImageView imageView = new ImageView(this);

        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;

        String imageType=options.outMimeType;
        if(imageWidth > imageHeight) {
            options.inSampleSize = calculateInSampleSize(options,100,100);//if landscape
        } else{
            options.inSampleSize = calculateInSampleSize(options,100,100);//if portrait
        }
        options.inJustDecodeBounds = false;
        //Bitmap
        try {
            File efile=new File(file[i].getAbsolutePath());
            if(efile.exists()) {
                mybitmap = BitmapFactory.decodeFile(file[i].getAbsolutePath(), options);


                imageView.setLayoutParams(layoutParams);
                imageView.setImageBitmap(mybitmap);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(1, 1, 1, 1);
                imageView.setColorFilter(34);
                imageView.setClickable(true);

                if (mybitmap != null) {
                    layout.addView(imageView);
                   // if (!((BitmapDrawable) imageView.getDrawable()).getBitmap().isRecycled()) {
                   //     ((BitmapDrawable) imageView.getDrawable()).getBitmap().recycle();
                  //  }
                }
                //else {layout.addView(imageView);}
                Log.d("Files", file[i].getName());              
            }
        } catch(Exception e) {Log.d("TAG","Error is " +e);}
    }
}