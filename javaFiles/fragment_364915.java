static public float dotProd(float[] a, float[] b){
    return a[0]*b[0]+a[1]*b[1]+a[2]*b[2];
}

static public float[] dif(float[] a, float[] b){
    return (new float[]{
            a[0]-b[0],
            a[1]-b[1],
            a[2]-b[2]
    });
}

static public float magn(float[] a){
    return (float) (Math.sqrt(a[0]*a[0]+a[1]*a[1]+a[2]*a[2]));
}