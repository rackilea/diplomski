public int[] negativeArray;
public int[] positiveArray;
public int negIndex = 0;
public int posIndex = 0;


public void arraySorter() {
    negativeArray = new int[maxNeg];
    positiveArray = new int[maxPos];
    for (int a = 0; a < max; a++) {
        if (intArray[a] < 0) {
            negativeArray[negIndex] = intArray[a];
            negIndex++;
        } else {
            positiveArray[posIndex] = intArray[a];
            posIndex++;
        }
    }
}