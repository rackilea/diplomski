public void set(double[] mySamples) {
  if (mySamples == null) {
    throw new IllegalArgumentException(
        "samples cannot be null");
  } else {
    samples = new double[mySamples.length];
    for (int i = 0; i < mySamples.length; i++) {
      samples[i] = mySamples[i];
    }
  }
}