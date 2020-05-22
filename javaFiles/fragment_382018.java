int a = 3;

void foo() {
    new Runnable() {
        @Override
        public void run() {
            a += 3;
        }
    };
}