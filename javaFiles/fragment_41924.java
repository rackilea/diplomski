Object[] nobjs = Arrays.copyOf(myObjects, myObjects.length - elemToRemove.length);
for (int i = 0, j = 0, k = 0; i < myObjects.length; i ++) {
    if (j < elemToRemove.length && i == elemToRemove[j]) {
        j ++;
    } else {
        nobjs[k ++] = myObjects[i];
    }
}