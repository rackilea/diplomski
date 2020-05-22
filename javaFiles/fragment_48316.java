for (int i=0; i < SIZE_Y; i++) {
    for (int j=0; j < SIZE_X; j++) {
        inp.read(buffer);
        int nextInt = (buffer[0] & 0xFF) | (buffer[1] & 0xFF) << 8 | (buffer[2] & 0xFF) << 16 | (buffer[3] & 0xFF) << 24;
        test_data[j][SIZE_Y - i - 1] = nextInt;
    }
}