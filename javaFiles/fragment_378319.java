Collections.sort(myArrayList, new Comparator<MyObject>() {

    public int compare(MyObject o1, MyObject o2) {
        return o1.getThing().compareTo(o2.getThing());
    }
});