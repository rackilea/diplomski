class MyToStringStyle extends ToStringStyle {
    public MyToStringStyle() {
        setFieldSeparator(" ");
        setUseFieldNames(false);
        setUseIdentityHashCode(false);
        setUseClassName(false);
        setContentStart("");
        setContentEnd("");
    }

    @Override
    protected void appendDetail(StringBuffer buffer, String fieldName, Collection<?> coll) {
        if (coll.isEmpty()) return;
        Iterator iter = coll.iterator();
        buffer.append(iter.next());
        while (iter.hasNext()) {
            buffer.append(" ").append(iter.next());
        }
    }
}