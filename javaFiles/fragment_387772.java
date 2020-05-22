//loop over both arrays at once
int arrayAIndex = 0;
int arrayBIndex = 0;
while (arrayAIndex < arrayA.length && arrayBIndex < arrayB.length) {
  if (arrayA[arrayAIndex] == arrayB[arrayBIndex]) {
    arrayAIndex++;
    arrayBIndex++;
  } else if (arrayA[arrayAIndex] > arrayB[arrayBIndex]) {
    addToResultB(arrayBIndex);
    arrayBIndex++;
  } else if (arrayB[arrayBIndex] > arrayA[arrayAIndex]) {
    addToResultA(arrayAIndex);
    arrayAIndex++;
  }
}

//clean up any elements which were not looked at during the above
while (arrayAIndex < arrayA.length) {
  addToResultA(arrayAIndex);
  arrayAIndex++;
}
while (arrayBIndex < arrayB.length) {
  addToResultB(arrayBIndex);
  arrayBIndex++;
}