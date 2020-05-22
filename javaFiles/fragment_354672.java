float[] bigA = {1,2,3,4};
float[][] wcs = new float[bigA.length][];
for(int i = 0; i < bigA.length;  ++i) {
  float abc = bigA[i] - 1;
  float[] bigerAbc = {abc};
  wcs[i] = bigerAbc;
}