int result = 0;
int i= 0;
while (bits != 0) {
    result |= (bits % 10) << i;
    i++;
    bits /= 10;
}