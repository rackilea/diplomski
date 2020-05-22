List<Foo> myList = getListFromSomePlace();
int frequency = Collections.frequency(Lists.transform(myList, new Function<Foo, MyObject>() {
    @Override
    public MyObject apply(Foo input) {
        return input.getInternalFoo();
    }
}), myCriteria);