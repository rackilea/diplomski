public List<Integer> getMaxFive() {
    Map<String, Integer> copy = null;
    synchronized(lockObject) {
        copy = new HashMap<String, Integer>(originalMap);
    }

    //sort the copy as usual
    return list;
}