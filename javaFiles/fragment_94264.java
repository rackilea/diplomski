void myMethod() { MyObject valueToReturn;

    MyObject.query(MyObject.class, ..., new StackMobQueryCallback<MyObject>() {
        @Override
        public void failure(StackMobException arg0) {
          //nothing to see here.
        }
        @Override
        public void success(List<MyObject> arg0) {
            valueToReturn = arg0.get(0);
        }
    });
    blockUnilItReturns()
    doSomethingWith(valueToReturn);
}