public static void main(String[] args) throws Exception {
    byte a = 0x14;
    byte b = 0x1;
    int c = or(a, b);
    System.out.println(Integer.toHexString(c));
}

static int or(byte a, byte b) {
    int c = 0;
    for (int i = 0; i < 8; i++) {
        if (bit(a, i) != 0 || bit(b, i) != 0) {
            c += Math.pow(2, i);
        }
    }
    return c;
}

static int bit(int x, int i) {
    return x / (int) Math.pow(2, i) % 2;
}