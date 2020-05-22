ArrayList<double[][]> testArray = new ArrayList<double[][]>();
int testArraySize = testArray.size();
double [][] testList = new double[testArraySize][];

for (int i = 0; i < testArraySize; i++) {
    testList[i] = testArray.get(i)[0];
}