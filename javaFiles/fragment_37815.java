// You're creating a ImageView
ImageView myImage = new ImageView(this);
LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

lp.setMargins(32, 8, 32, 8);
myImage.setLayoutParams(lp);
myImage.setImageBitmap(bitmap1);

// You're setting a new ImageView to array
myImages[CityImageCount] = new ImageView(this);
// then you set the Id
myImages[CityImageCount].setId(CityImageCount);

// But then you discard it by setting the array item with myImage
// so you're discarding the id.
myImages[CityImageCount] = myImage;