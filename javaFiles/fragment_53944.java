public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i < 3; i++) {
        loop1();
        loop2();
        loopBoth();
    }

    long start = System.nanoTime();

    loop1();

    long end = System.nanoTime();
    System.out.println((end - start) / 1000000);

    start = System.nanoTime();
    loop2();
    end = System.nanoTime();
    System.out.println((end - start) / 1000000);

    start = System.nanoTime();
    loopBoth();
    end = System.nanoTime();
    System.out.println((end - start) / 1000000);
}

public static void loop1() {
    int a = 188, aMax = 0;
    for (int i = 0; i < 1000000000; i++) {
        int t = a ^ i;
        if (t > aMax) {
            aMax = t;
        }
    }
    System.out.println(aMax);
}

public static void loop2() {
    int b = 144, bMax = 0;
    for (int i = 0; i < 1000000000; i++) {
        int t = b ^ i;
        if (t > bMax) {
            bMax = t;
        }
    }
    System.out.println(bMax);
}

public static void loopBoth() {
    int a = 188, b = 144, aMax = 0, bMax = 0;

    for (int i = 0; i < 1000000000; i++) {
        int t = a ^ i;
        if (t > aMax) {
            aMax = t;
        }
        int u = b ^ i;
        if (u > bMax) {
            bMax = u;
        }
    }
    System.out.println(aMax);
    System.out.println(bMax);
}