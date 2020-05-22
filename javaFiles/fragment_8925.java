private String findMinimumPricedHelper(String name, IMedia[] treeArray, int index) {
    if (some conditions) {
        return treeArray[index].toString();
    } else {
        return findMinimumPricedHelper(name, treeArray, index+1);
    }
}