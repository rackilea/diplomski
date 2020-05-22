RequestOptions requestOptions = new RequestOptions();
 requestOptions.override(120, 120);
 requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);

 Glide.with(context)
   .load("URL HERE")
   .apply(requestOptions)
   .into(imageView);