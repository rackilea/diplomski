class X<T> {
    public void helloThere(T obj) { }

    class Y<T> {
        // Ignore any syntactical error about method calling.
        public void callHelloThere(T obj) {
            helloThere(obj);
        }
    }
}