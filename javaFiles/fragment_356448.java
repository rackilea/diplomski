ImageLoader imageLoader = null;
                            imageLoader =ImageLoader.getInstance();
                            if(image_uri!=null)
                            {

                                options = new DisplayImageOptions.Builder()
                                        .showImageOnFail(R.drawable.profile)
                                        .showImageForEmptyUri(R.drawable.profile)
                                        .showImageOnLoading(R.drawable.profile)
                                        .cacheInMemory(true)
                                        .cacheOnDisc(true)
                                        .considerExifParams(true)
                                        .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                                        .displayer(new RoundedBitmapDisplayer(200)).build();


                                imageLoader.displayImage(image_uri, img,options);
                            }
                            else
                            {
                                imageLoader.displayImage("drawable://" +R.drawable.profile, img,options);
                            }