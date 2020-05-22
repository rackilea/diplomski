public void filterList(List<MyObject> myList, String testString) {
    CollectionUtils.filter(myList, new Predicate<MyObject>() {
        @Override
        public boolean evaluate(MyObject myObject) {
            return myObject.getAccountId().equals(testString);
        }
    });
}