class MyList {

    private List<List<Integer>> mList = new ArrayList<List<Integer>>();

    public void set(int i, int k, int value) {
        List<Integer> list;

        if (i == mList.size()) {
            list = new ArrayList<Integer>();
            mList.add(i, list);
        } else {
            list = mList.get(i);
        }

        if (k == list.size()) {
            list.add(value);
        } else {
            list.set(k, value);
        }
    }

    public int get(int i, int k) {
        return mList.get(i).get(k);
    }
}