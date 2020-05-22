Kernel kernel = new Kernel() {
    @Override
    public void run() {
        int gid = getGlobalId();
        sum[gid] = (float)(Math.cos(Math.sin(a[gid])) + Math.sin(Math.cos(b[gid])));
    }
};