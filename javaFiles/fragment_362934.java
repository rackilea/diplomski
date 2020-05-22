class XORShift{
    private int x, y, z, w;

    public XORShift(int seed){
        x = seed;
        y = seed >>> 20 | seed << 12;
        z = seed >>> 10 | seed << 22;
        w = seed >>> 25 | seed << 7;
    }

    public int next() {
        int t = x;
        t ^= t << 11;
        t ^= t >> 8;
        x = y; y = z; z = w;
        w ^= w >> 19;
        w ^= t;
        return w;
    }
}