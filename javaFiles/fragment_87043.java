int remaining = length;
int offset = 0;
while (remaining > 0) {
    int count = in.read(textBytes, offset, remaining);
    if (-1 == count) {
        // deal with it
        break;
    }
    remaining -= count;
    offset += count;
}