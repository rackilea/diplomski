int length = 0;
try {
    while (true) {
        Object o = objects[length];
        length++;
    }
} catch (ArrayIndexOutOfBoundsException e) {
    // ignore
}