DataBuffer db1 = img1.getData().getDataBuffer();
    DataBuffer db2 = img2.getData().getDataBuffer();

    int totalDiff = 0;
    int x, y;
    if (db1 instanceof DataBufferInt && db2 instanceof DataBufferInt) {
        int[] data1 = ((DataBufferInt) db1).getData();
        int[] data2 = ((DataBufferInt) db2).getData();
        for (int i = 0; i < WIDTH * HEIGHT; ++i) {
            x = data1[i];
            y = data2[i];

            totalDiff += Math.abs((x & 0xFF) - (y & 0xFF))
                + Math.abs(((x & 0xFF00) >> 8) - ((y & 0xFF00) >> 8))
                + Math.abs(((x & 0xFF0000) >> 16) - ((y & 0xFF0000) >> 16));
        }
    } else {
        for (int i = 0; i < WIDTH * HEIGHT; ++i) {
            x = db1.getElem(i);
            y = db2.getElem(i);

            totalDiff += Math.abs((x & 0xFF) - (y & 0xFF))
                    + Math.abs(((x & 0xFF00) >> 8) - ((y & 0xFF00) >> 8))
                    + Math.abs(((x & 0xFF0000) >> 16) - ((y & 0xFF0000) >> 16));
        }
    }