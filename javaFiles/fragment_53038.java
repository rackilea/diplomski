Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
Canvas canvas = new Canvas(output);

int space = 10; // the space between images

for(int i = 0; i < 3; i++) {
    canvas.drawBitmap(smallImage, i * (smallImage.getWidth() + space), 0, null);
}

// do whatever you want with output