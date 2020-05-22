int[] firstArray= {3, 4, 4, 5};
    int secondArray[] = {2, 4, 4, 5};

    int fLen = firstArray.length;
    int sLen = secondArray.length;

    int thirdArray[] = new int[fLen+sLen];

    System.arraycopy(firstArray, 0, thirdArray, 0, fLen);
    System.arraycopy(secondArray, 0, thirdArray, fLen, sLen);

    for(int i: thirdArray){
        System.out.print(i + " ");
    }