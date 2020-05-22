class ValueComparator implements Comparator<Object> {

Map<String, Integer> base;

public ValueComparator(Map<String, Integer> base) {
    this.base = base;
}

public int compare(Object a, Object b) {

    if (((Integer) base.get(a)).intValue() < ((Integer) base.get(b)).intValue()) {
        return 1;
    } else if ( ((Integer) base.get(a)).intValue() == ((Integer) base.get(b)).intValue()) {
        return ((String)a).compareTo(((String)b));
    } else {
        return -1;
    }
}
}