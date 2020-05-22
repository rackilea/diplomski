try
 {
    ImageView imageView = (ImageView) findViewById(R.id.Yourimageview);
    String imageName = "model_" + uv.categoryID;
    int id = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
    imageView.setImageResource(id);
 }
 catch(Exception ex)
 {
     Log.e(TAG, ex);
 }