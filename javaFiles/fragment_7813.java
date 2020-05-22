Collections.sort(li,new Comparator<Number>() {
    @Override
    public int compare(Number o1, Number o2) {
        Double d1 = (o1 == null) ? Double.POSITIVE_INFINITY : o1.doubleValue();
        Double d2 = (o2 == null) ? Double.POSITIVE_INFINITY : o2.doubleValue();
        return  d1.compareTo(d2);
    }
});