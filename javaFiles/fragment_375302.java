static byte[] utf8(IntStream codePoints) {
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    final byte[] cpBytes = new byte[6]; // IndexOutOfBounds for too large code points
    codePoints.forEach((cp) -> {
        if (cp < 0) {
            throw new IllegalStateException("No negative code point allowed");
        } else if (cp < 0x80) {
            baos.write(cp);
        } else {
            int bi = 0;
            int lastPrefix = 0xC0;
            int lastMask = 0x1F;
            for (;;) {
                int b = 0x80 | (cp & 0x3F);
                cpBytes[bi] = (byte)b;
                ++bi;
                cp >>= 6;
                if ((cp & ~lastMask) == 0) {
                    cpBytes[bi] = (byte) (lastPrefix | cp);
                    ++bi;
                    break;
                }
                lastPrefix = 0x80 | (lastPrefix >> 1);
                lastMask >>= 1;
            }
            while (bi > 0) {
                --bi;
                baos.write(cpBytes[bi]);
            }
        }
    });
    return baos.toByteArray();
}