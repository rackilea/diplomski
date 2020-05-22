private int[] tab;

public Example(int size) {
    tab = new int[size];
    for (int i = 0; i < size; i++)
        tab[i] = (int) (Math.random() * 100);
}