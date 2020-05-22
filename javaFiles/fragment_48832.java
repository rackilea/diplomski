for (int j = 0; j < endList.size(); j++) {
    Integer[] newLine = new Integer[numBins];
    newLine[0] = i;
    Integer[] newLineEnd = endList.get(j);
    for (int k = 0; k < numBins - 1; k++)
        newLine[k + 1] = newLineEnd[k];
    indexList.add(newLine);
} // next j