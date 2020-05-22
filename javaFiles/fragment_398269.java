short b0 = (buffer[0] & 255); // trick converts to unsigned
short b1 = (buffer[1] & 255);
int val = b0 | (b1 << 8);

// or just put it all inline:
int val = (buffer[0]&255) | ((buffer[1]&255) << 8);