ViewGroup layout = (ViewGroup) inflater.inflate(resId, collection, false);

ImageView imageView = (ImageView) layout.findViewById(R.id.id_of_your_imageview);
Picasso.with(mContext).load(R.drawable.id_of_your_image_resource).into(imageView);

collection.addView(layout);
return layout;