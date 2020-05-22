String[] images =getAssets().list("images");
ArrayList<String> listImages = new ArrayList<String>(Arrays.asList(images));

Now to set image in imageview you first need to get bitmap using image name from assets :

InputStream inputstream=mContext.getAssets().open("images/"
                                      +listImages.get(position));
Drawable drawable = Drawable.createFromStream(inputstream, null);
imageView.setImageDrawable(drawable);