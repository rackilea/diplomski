private float[] gaussianData() {
    float[] a = new float[COUNT];
    for (int i = 0; i < a.length; i++) {
        if (i % 10 == 0) a[i] = randomValue();
    }
    return a;
}