Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.xyz);

//you also can use other logic to get a bitmap, this according to your app logic

//create a crop area rectangle
//this crop area rectangle should calculate from the points array
Bitmap croppedBitmap = Bitmap.createBitmap(bmp, x, y, cropWidth, cropHeight);