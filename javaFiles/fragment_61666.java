// initialize background
Bitmap bm = Bitmap.getBitmapResource("myImage");
Background bg = BackgroundFactory.createBitmapBackground(bm);

// getMainManager(), apply background
testScreen.getMainManager().setBackground(bg);