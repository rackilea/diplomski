@Override public void getView(int position, View convertView, ViewGroup parent) {
         if (convertView == null) {
    imageView = new ImageView(activity);
    imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    imageView.setPadding(5, 5, 5, 5);
    } else {
    imageView = (ImageView) convertView;
    }
    String url = "http://192.168.1.8/Yourguideapplication/"+Image_url[position]);
    Picasso.with(context).load(url).into(imageView);
    return imageView;           
        }