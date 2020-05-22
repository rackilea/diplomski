float[][] vectorToMx(Vector<Float> v) {
    float[][] m = new float[3][1];
    m[0][0] = v.get(0);
    m[1][0] = v.get(1);
    m[2][0] = v.get(2);
    return m;
}