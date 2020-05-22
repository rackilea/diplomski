double x, y, z;
int dimension;
Test(double x, double y, double z) {
    initDim(x, y, z);
}
Test(double x, double y) {
    initDim(x, y);
}
Test(double[] p)
{
    if(p.length == 2)
        initDim(p[0], p[1]);
    else if(p.length == 3)
        initDim(p[0], p[1], p[2]);
}
private void initDim(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
    dimension = 3;
}

private void initDim(double x, double y) {
    initDim(x, y, 0);
    dimension = 2;
}