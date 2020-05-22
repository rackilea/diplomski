public static Picture fromBitmap(Bitmap src) {
    Picture dst = Picture.create((int)src.getWidth(), (int)src.getHeight(), RGB);
    fromBitmap(src, dst);
    return dst;
}

public static void fromBitmap(Bitmap src, Picture dst) {
    int[] dstData = dst.getPlaneData(0);
    int[] packed = new int[src.getWidth() * src.getHeight()];

    src.getPixels(packed, 0, src.getWidth(), 0, 0, src.getWidth(), src.getHeight());

    for (int i = 0, srcOff = 0, dstOff = 0; i < src.getHeight(); i++) {
        for (int j = 0; j < src.getWidth(); j++, srcOff++, dstOff += 3) {
            int rgb = packed[srcOff];
            dstData[dstOff]     = (rgb >> 16) & 0xff;
            dstData[dstOff + 1] = (rgb >> 8) & 0xff;
            dstData[dstOff + 2] = rgb & 0xff;
        }
    }
}