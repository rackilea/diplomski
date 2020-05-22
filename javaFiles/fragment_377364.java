int a, b, c, d;
    double e;

    a = 3;
    b = 4;
    c = 5;
    d = 6;
    e = a + (double) b / c * d;
    System.out.println("e=" + e);
    e = a + (((double) b) / c) * d; // Java: 7.8
    System.out.println("e=" + e);