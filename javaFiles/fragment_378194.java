final Drawable image;
Resources res = getResources();
image = res.getDrawable(items2[position].icon);
image.setBounds(0, 0, 50, 50);
tv.setCompoundDrawables(image, null, null, null);

//tv.setCompoundDrawablesWithIntrinsicBounds(image,0,0,0);//items2[position].icon, 0, 0, 0);