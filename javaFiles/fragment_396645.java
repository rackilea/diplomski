short[] invert = new short[256];
for (int i = 0; i < 256; i++) {
    invert[i] = (short) (255 - i);
}
BufferedImageOp invertOp = new LookupOp(new ShortLookupTable(0, invert), null));
invertOp.filter(src, dst);