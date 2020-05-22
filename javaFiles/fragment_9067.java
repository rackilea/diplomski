//read image from asset
InputStream is = getAssets().open("image.jpg");

//    create a drawable
Drawable drawable = Drawable.createFromStream(is, null);

//find reference to your imageview and set drawable
ImageView i=(ImageView)findViewById(R.id.image_id); 
i.setImageDrawable(drawable);