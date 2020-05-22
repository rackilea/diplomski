new Filter<MyClass>() {

        @Override
        public boolean include(MyClass item) {
            return item.getName().matches("some regex");
        }
    };