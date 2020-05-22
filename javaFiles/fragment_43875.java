YourActivity.class

    byte[] byteArrayExtra = getIntent().getByteArrayExtra("photo");

    //BitmapOptions is optional you can create bitmap without this also. This is the description of its use from google developer docs.
    //BitmapFactory.Options: null-ok; Options that control downsampling and whether the image should be completely decoded, or just is size returned.

    Bitmap bitmap = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length, new BitmapFactory.Options());

    //or
    Bitmap bitmap = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);


    imageview.setimageBitmap(bitmap);