class TenArray implements Array {
    private long v0;
    private long v1;
    private long v2;
    private long v3;
    private long v4;
    private long v5;
    private long v6;
    private long v7;
    private long v8;
    private long v9;
    private long[] extras;

    public TenArray(int size) {
        if (size > 10) {
            extras = new long[size - 10];
        }
    }

    @Override
    public long get(final int i) {
        switch (i) {
        case 0:
            return v0;
        case 1:
            return v1;
        case 2:
            return v2;
        case 3:
            return v3;
        case 4:
            return v4;
        case 5:
            return v5;
        case 6:
            return v6;
        case 7:
            return v7;
        case 8:
            return v8;
        case 9:
            return v9;
        default:
            return extras[i - 10];
        }
    }

    @Override
    public void set(final int i, final long v) {
        switch (i) {
        case 0:
            v0 = v; break;
        case 1:
            v1 = v; break;
        case 2:
            v2 = v; break;
        case 3:
            v3 = v; break;
        case 4:
            v4 = v; break;
        case 5:
            v5 = v; break;
        case 6:
            v6 = v; break;
        case 7:
            v7 = v; break;
        case 8:
            v8 = v; break;
        case 9:
            v9 = v; break;
        default:
            extras[i - 10] = v;
        }
    }
}