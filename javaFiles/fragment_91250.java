Button obamabutton = (Button)findViewById(R.id.obamabutton);
obamabutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ImageView obama = (ImageView)findViewById(R.id.imageView);

        BitmapFactory.Options ops = new BitmapFactory.Options();
        ops.inSampleSize = 4;
        ops.inDither = false;
        ops.inMutable = true;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.obama, ops);
        obama.setImageBitmap(bitmap);;
    }
});