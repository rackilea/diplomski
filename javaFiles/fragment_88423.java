byte[] image = services.getImageBuffer(1024, 600);

    Bitmap bmp = Bitmap.createBitmap(1024, 600, Bitmap.Config.RGB_565);
    int row = 0, col = 0;
    for (int i = 0; i < image.length; i += 3) {
        bmp.setPixel(col++, row, image[i + 2] & image[i + 1] & image[i]);

        if (col == 1024) {
            col = 0;
            row++;
        }