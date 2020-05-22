void foo() {
    int a = 3;
    new Runnable() {
        @Override
        public void run() {
            a += 3;
        }
    };
}