try
{
    Bitmap bitmap = loadBitmap("http://i2.ytimg.com/vi/"+ allMatches.get(position).toString() + "/default.jpg"); 
    imageView.setImageBitmap(bitmap);
}
catch(IOException e)
{
    System.err.println("Couldn't load image: "+e.getMessage());
    imageView.setImageDrawable(getResources().getDrawable(R.drawable.default1)); 
}