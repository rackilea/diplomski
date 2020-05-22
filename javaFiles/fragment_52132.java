ImageView mImgView = (ImageView) findViewById(R.id.imageView);
Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(),
            R.drawable.some_image);

// bitmap image, radius
mImgView.setImageBitmap(RoundedImageView.getCroppedBitmap(bitmap, 360));