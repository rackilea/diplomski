Comparator<MyClass> someFieldComparator = new Comparator<MyClass>() {
    @Override
    public int compare(MyClass m1, MyClass m2) {
        return m1.getSomeField().compareTo(m2.getSomeField());
    }
};