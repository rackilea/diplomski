public static void main(String[] args) {
    new1(4);
}

public static void new1(int n) {
    if (n <= 0) {
        return;
    } else {
        System.out.print("-");
        --n;
        new1(n);
        System.out.println();
        loop(n);
    }

}

static void loop(int n) {
    if (n > 0) {
        System.out.print("!!!-");
        loop(n - 1);
    }
}