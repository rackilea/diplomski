@Override
    protected void onActivityResult(int requestCode , int resultCode , Intent data){
        if(resultCode == RESULT_OK){
            Uri imageUri;
            if(data == null || data.getData()== null){
                imageUri = uriPhoto;
//                Log.i("URI","HERE");
            }else{
                imageUri = data.getData();
            Log.i("URI",imageUri.toString());

            BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
            bmpFactoryOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;

            Uri imageUri = data.getData();
            Bitmap bmp = MediaStore.Images.Media.getBitmap(
                                                  this.getContentResolver(),
                                                  imageUri);

            Mat obj = new Mat(bmp.width, bmp.height, CvType.CV_8UC4)
            Utils.bitmapToMat(bmp, obj)
            Log.i("URI" , "MAT OBJECT CREATED SUCCESSFULLY");
            Log.i("URI" , String.valueOf(obj.cols()));
            Log.i("URI" , String.valueOf(obj.rows()));
        }
        Intent intent = new Intent();
        intent.setData(imageUri);
        setResult(RESULT_OK , intent);
        finish();
    }