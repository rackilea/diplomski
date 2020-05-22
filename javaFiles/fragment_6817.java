void someMethod(long l) {
    int i = 0;
    while (i < l) {
        if (i == maxVal) {
            throw new RuntimeException;
        }
        i++;
    }...