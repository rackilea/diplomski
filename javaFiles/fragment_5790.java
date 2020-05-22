private ImageView imageView;
    imageView = (ImageView) findViewById(R.id.image_view);
    SharedPreferences pref = getSharedPreferences("Images", Context.MODE_PRIVATE);
    int res = pref.getInt("IMG",0);
    if(res!=0)
    {
        imageView.setImageResource(res);

    }