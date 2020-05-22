if (c < 0x80) {
    return c;
} else if (c < 0x800) {
    return 0xc0 | c >> 6;
} else if (c < 0x10000) {
    return 0xe0 | c >> 12; 
} else {
    return 0xf0 | c >> 18;
}