ImageView image = (ImageView) v.findViewById(R.id.avatar);

   image.setImageBitmap(getBitmap(image_url));

  public Bitmap getBitmap(String bitmapUrl) 
           {
               try  
               {
                 URL url = new URL(bitmapUrl);
                 return BitmapFactory.decodeStream(url.openConnection().getInputStream()); 
                }
                catch(Exception ex) {return null;}
}