List<Object> list = new ArrayList<Object>() {
    public int indexOf(Object o) {
        System.out.println(o.getClass());
        return super.indexOf(o);
    }
};