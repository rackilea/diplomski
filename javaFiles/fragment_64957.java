Collections.sort(sortedList, new Comparator<Date>(){

    @Override
    public int compare(Date o1, Date o2) {
        return o1.compareTo(o2);
     }
});