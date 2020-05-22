public static int format(char[] buffer, float value, int decimals) {
    float v = value;
    for (int i = 0; i < decimals; i++)
        v *= 10f;
    int num = Math.round(v);
    int idx = buffer.length;
    for (int i = 0; i < decimals; i++, num /= 10)
        buffer[--idx] = (char) ('0' + num % 10);
    if (decimals > 0)
        buffer[--idx] = '.';
    do {
        buffer[--idx] = (char) ('0' + num % 10);
    } while ((num /= 10) != 0);
    return idx;
}