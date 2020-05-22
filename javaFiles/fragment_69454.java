Comparator<MyClass> otherFieldComparator = new Comparator<MyClass>() {
    @Override
    public int compare(MyClass m1, MyClass m2) {
        int v1 = m1.getOtherField();
        int v2 = m2.getOtherField();
        if (v1 < v2) {
            return -1;
        }
        if (v1 > v2) {
            return 1;
        }
        return 0;
    }
};