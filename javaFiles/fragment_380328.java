static char decrypt(char c) {
    char d = '~' - '!' + 1;
    int x = (c - '!' - 1000) % d;
    if (x < 0) x += d;
    return (char)('!' + x);
}