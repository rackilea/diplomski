public static int interleave(short b1, short b2) {
    return((int)(((b2 * 0x0101010101010101L & 0x8040201008040201L) * 
        0x0102040810204081L >> 49) & 0x5555) |
        (int)(((b1 * 0x0101010101010101L & 0x8040201008040201L) * 
        0x0102040810204081L >> 48) & 0xAAAA));
}