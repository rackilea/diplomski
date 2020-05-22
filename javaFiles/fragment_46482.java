v = 0xa0b;
    v = swapBytes(v);
    System.out.println(Integer.toHexString(v)); // 0xb0a


    public static int swapBytes(int v) {
        return ((v << 8)&0xFF00) | ((v >> 8) & 0xFF);
    }