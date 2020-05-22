public int searchGraph(int baseIndex, int searchIndex, int count) {
    if(baseIndex == searchIndex) {
        return count;
    } else if(count > indexToIndecies.size()) {
        return Integer.MAX_VALUE; // cycle in graph
    } else {
        int returnVal = Integer.MAX_VALUE;
        for(int i = 0; i < indexToIndecies.get(baseIndex).size(); i++) {
            int temp = searchGraph(indexToIndecies.get(baseIndex).get(i), searchIndex, count + 1);
            returnVal = temp < returnVal ? temp : returnVal;
        }
        return returnVal;
    }
}