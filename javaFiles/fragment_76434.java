int[] intBuf = null;
try {
    intBuf = util.getAbgrRect(page, x, y, w, h, wPix, hPix);
} catch(OutOfMemoryError e) {
    // abort processing
}