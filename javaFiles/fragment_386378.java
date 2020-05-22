try 
{
    // get input stream
    InputStream ims = getAssets().open("avatar.jpg");
    // load image as Drawable
    Drawable d = Drawable.createFromStream(ims, null);
    // set image to ImageView
    iv.setImageDrawable(d);
}
catch(IOException ex) 
{
    ex.printStackTrace();
}