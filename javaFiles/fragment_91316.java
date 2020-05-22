public static void main(String[] args) {
    B b = new B() {
        @Override
        public void doSomething() {
            super.doSomething();
            System.out.println("new B");
        }
    };
    b.doSomething();
}