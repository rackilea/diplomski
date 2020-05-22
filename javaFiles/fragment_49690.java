private int[] tab = new int[10];

public Example(int initial) {
    for (int i = 0; i < 10; i++)
        tab[i] = initial;
}

public Example() {
    for (int i = 0; i < 10; i++)
        tab[i] = (int) (Math.random() * 100);
}