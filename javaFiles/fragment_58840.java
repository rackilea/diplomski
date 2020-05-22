volatile int[] integers;

public void resizeAndAddLast(int value) {
    int[] copy = Arrays.copyOf(integers, integers.length + 1);
    copy[copy.length - 1] = value;
    integers = copy;
}

public int read(int index) {
    return integers[index];
}