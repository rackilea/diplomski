final int width = image.getWidth(),
              height = image.getHeight(),
              rowBitWidth = ((width + 7) / 8) * 8;

    for (int j = 0; j < height; j++) {
        for (int i = 0; i < width; i++) {
            int byte_index = (i + j * rowBitWidth) / 8;
            int bit_index = (i + j * rowBitWidth) % 8;
            byte_buffer[byte_index] |= 1 << bit_index;
        }
    }