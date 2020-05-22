class A<T> {
    class B<S> {
        public <U extends S> U tsu() {
            return null;
        }
    }
}

List<String> list = new A<Integer>().new B<List>().<List<String>>tsu();