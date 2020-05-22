List<MyObject> list = ...;
Collections.sort(list, new Comparator<MyObject>() {
    public int compare(MyObject o1, MyObject o2) {
        if (o1.getDistance() == o2.getDistance()) { 
             return 0;
        } else { 
           return o1.getDistance() > o2.getDistance() ? 1 : -1;
        }
    }
});