static boolean checkCycle(int src, int dest) {

    int srcRoot = findParent(src);
    int destRoot = findParent(dest);
    if (srcRoot == destRoot ) {
        return true;
    }
    parent[destRoot] = srcRoot;
    return false;
}