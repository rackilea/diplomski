class Example implements Iterable<Base> {
        @Override
        public Iterator<Base> iterator() {
            return Arrays.<Base>asList(new Derived()).iterator();
        }
    }