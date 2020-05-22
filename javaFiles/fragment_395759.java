public void DisplayImage(String url, ImageView imageView)
{
    imageViews.put(imageView, url);
    Bitmap bitmap=memoryCache.get(url);
    if(bitmap!=null) {
       BitmapDrawable bd = new BitmapDrawable(bitmap);
       imageView.setBackgroundDrawable(bd);
    }
    else
    {
        queuePhoto(url, imageView);
        imageView.setImageResource(stub_id);
    }
}