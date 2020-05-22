public void foo(final String str) {
    Printer p = new Printer() {
        public void print() {
            System.out.println(str);
        }
    };
    p.print();
}