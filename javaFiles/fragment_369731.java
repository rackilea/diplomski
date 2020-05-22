public int compare(Map<String, Object> m2, Map<String, Object> m1) {
    int cmp = m1.get("Foo").toString().compareTo(m2.get("Foo").toString());
    if (cmp == 0) {
        return m1.get("Bar").toString().compareTo(m2.get("Bar").toString());
    }
    return cmp;
}