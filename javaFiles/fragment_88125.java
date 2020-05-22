public static int size = 30;

public static void main(String args[]) {
    int kyo[] = new int[size];

    add(kyo);

    for (int x : kyo) {
        System.out.print(x + " ");
    }
}

static void add(int x[]) {
    for (int g = 0; g < x.length; g++) {
        x[g] = g;
    }
}