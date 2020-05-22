ImageView myImage = new ImageView(this);
LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

lp.setMargins(32, 8, 32, 8);
myImage.setLayoutParams(lp);
myImage.setImageBitmap(bitmap1);

myImages[CityImageCount] = myImage;
myImages[CityImageCount].setId(CityImageCount);