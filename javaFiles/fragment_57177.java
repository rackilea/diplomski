private double[][] featureMatrix;

public void setFeatureMatrix(int stride, List<Double> vector) {
  this.featureMatrix = new double[vector.size() / stride][stride];
  for (int i = 0; i < vector.size(); i++) {
    this.featureMatrix[i / stride][i % stride] = vector.get(i);
  }
}

public static void createPatchFeature(double[][] featureMatrix, Feature feature,
    ObjectFactory factory) {
  PatchFeature patchFeature = factory.createPatchFeature();
  int stride = featureMatrix[0].length;
  // int vectorSize = stride * featureMatrix.length;
  patchFeature.setStride(stride);
  DoubleVector vector = factory.createDoubleVector();
  for (int i = 0; i < featureMatrix.length; i++) {
    for (int j = 0; j < stride; j++) {
      vector.getDbl().add(featureMatrix[i][j]);
    }
  }
  patchFeature.setFeatureVector(vector);
  feature.setPatch(patchFeature);
}