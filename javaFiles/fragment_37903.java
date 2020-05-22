void method(int n) {
    if (n == 1) {
        for (int i = 0; i < 10000; i++) {
            method(0);
        }
    }
}

method(1);