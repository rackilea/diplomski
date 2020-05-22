double computeSimilarity(double[] a, double[] b) {
  //todo: you might want to check they are the same size before proceeding

  double dotProduct = 0;
  double normASum = 0; 
  double normBSum = 0;

  for(int i = 0; i < a.length; i ++) {
      dotProduct += a[i] * b[i];
      normASum += a[i] * a[i];
      normBSum += b[i] * b[i];
  }

  double eucledianDist = Math.sqrt(normASum) * Math.sqrt(normBSum);
  return dotProduct / eucledianDist;
}