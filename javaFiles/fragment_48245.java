/* Make alpha channel more opaque.
 * Modify the alpha (opacity) channel so that values are higher, but still
 * continuous and monotonically increasing.
 */
private static void adjustOpacity(BufferedImage shadowImage) {
    // Use a lookup table with four arrays;
    // the three for RGB are identity arrays (no change).
    byte identityArray[] = new byte[256];
    for (int i=0; i < 256; i++)
        identityArray[i] = (byte)i;

    byte alphaArray[] = new byte[256];
    // map the range (0..256] to (0..pi/2]
    double mapTo90Deg = Math.PI / 2.0 / 256.0;
    for (int i=0; i < 256; i++) {
        alphaArray[i] = (byte)(Math.sin(i * mapTo90Deg) * 256);
    }

    byte[][] tables = {
            identityArray,
            identityArray,
            identityArray,
            alphaArray
    };
    ByteLookupTable blut = new ByteLookupTable(0, tables);
    LookupOp op = new LookupOp(blut, null);

    // With LookupOp, it's ok for src and dest to be the same image.
    op.filter(shadowImage,  shadowImage);
}