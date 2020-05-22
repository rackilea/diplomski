for (MatrixColumn matrixCol : matrix) {
  double diff1 = matrixCol.getRatingForItemID1() - avgRatingForPreferredItem;
  double diff2 = matrixCol.getRatingForItemID2() - avgRatingForPreferredItem;
  numitorStanga += diff1 * diff1;
  numitorDreapta += diff2 * diff2;
}