Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.thn);
ImageView iv = (ImageView)findViewById(R.id.image_view1);
iv.setImageBitmap(bm);

iv = (ImageView)findViewById(R.id.image_view2);
String b = getStringImage(bm);
decodeImage(iv, b);