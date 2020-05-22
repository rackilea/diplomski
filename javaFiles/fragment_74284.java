public Comparator<Data> createComparatorForAttribute(final String attribute) {
    return new Comparator<Data>() {
        @Override
        public int compare(Data d1, Data d2) {
            return d1.getValue(attribute) - d2.getValue(attribute);
        }
    };
}