// Start
rgb = (0xff000000) | (0 << 16) | (r << 8) | (0 << 0);

// 1. Do the parts in parentheses. Notice the green value was shifted over two bits
rgb = 0xff000000 | 0x00000000 | 0x0000rr00 | 0x00000000;

// 2. Apply the ORs
rgb = 0xff00rr00;