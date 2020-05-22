int width = 225;
    int height = 160;
    int size = width * height;
    int[] pixelData = new byte[size];
    for (int i = 0; i < size; i++) {
        // pack 4 bytes into int for ARGB_8888
        pixelData[i] = ((0xFF & (byte)255) << 24) // alpha, 8 bits
                | ((0xFF & (byte)255) << 16)      // red, 8 bits
                | ((0xFF & (byte)0) << 8)         // green, 8 bits
                | (0xFF & (byte)0);               // blue, 8 bits
    }

    Bitmap image = Bitmap.createBitmap(pixelData, width, height, Bitmap.Config.ARGB_8888);