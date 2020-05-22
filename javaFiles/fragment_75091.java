class NextPrevList {
    private int index = 0;
    private List currentList; //initialize it with some list

    public Object next() {
        return list.get(++index);
    }
    public Object prev() {
        //maybe add a check for out of bounds
        if (index == 0) return null;
        return list.get(--index);
    }
}