public ArrayList<ArrayList<Integer>> deepCopy(ArrayList<ArrayList<Integer>> list) {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    deepCopy(list.iterator, ret);
    return ret;
}

private void deepCopy(Iterator<ArrayList<Integer>> it, ArrayList<ArrayList<Integer>> ret) {
    if (it.hasNext()) {
        ret.add(new ArrayList(it.next()));
        deepCopy(it, ret);
    }
}