public static void main(String[] args) {
    int i = 0;
    while (i < 10) {
        System.out.println(i);
        i = skip(i);
    }
}

public static int skip(int i) {
    return (i == 4) ? i + 2 : i + 1;
}