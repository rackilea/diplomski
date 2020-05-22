List<Integer> solve(int... a) {
    //Value in each element is the index, from where we can come here
    int[] path = new int[a.length];
    Arrays.fill(path, -1); //No index is accessible yet

    //Queue of positions that were visited from somewhere, but nothing was tried to be 
    //visited from them. At the beginning, 0 is in the list, because it's starting point.
    //Then, if we visit index 3, it is added to this list for later processing.
    Queue<Integer> posQueue = new LinkedList<>();
    posQueue.add(0);
    path[0] = 0; //0 index is accessible from itself, this is starting position

    while (!posQueue.isEmpty()) {
        int pos = posQueue.remove();
        int prPos = pos - a[pos];
        int nxPos = pos + a[pos];
        if (prPos >= 0 && path[prPos] == -1) {
            path[prPos] = pos;
            posQueue.add(prPos);
        }
        if (nxPos < a.length && path[nxPos] == -1) {
            path[nxPos] = pos;
            posQueue.add(nxPos);
        }

        if (path[a.length-1] != -1) {
            break;
        }
    }

    if (path[a.length-1] == -1) {
        return null;
    }

    //Collect the path
    List<Integer> result = new ArrayList<>();
    int idx = a.length-1;
    while (idx != 0) {
        result.add(0, idx);
        idx = path[idx];
    }
    result.add(0, 0);
    return result;
}