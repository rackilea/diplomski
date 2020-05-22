for (MatrixColumn matrixCol : matrix) {
 numitorStanga  += (matrixCol.getRatingForItemID1() - avgRatingForPreferredItem)
                 * (matrixCol.getRatingForItemID1() - avgRatingForPreferredItem);
 numitorDreapta += (matrixCol.getRatingForItemID2() - avgRatingForRandomItem) 
                 * (matrixCol.getRatingForItemID2() - avgRatingForRandomItem);
}