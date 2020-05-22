public static void main(String[] args) {
    Random r = new Random(98765);
    char[] buf = new char[98765];
    for (int i = 0; i < buf.length; i++)
        buf[i] = (char)('0' + r.nextInt(10));

    String x = new String(buf);
    int y = 98765;

    System.out.println(testMarkDickinson(x, y));
    System.out.println(testHovercraftFullOfEels(x, y));
    System.out.println(testMrM(x, y));

    long test1nano = 0, test2nano = 0, test3nano = 0;
    for (int i = 0; i < 10; i++) {
        long nano1 = System.nanoTime();
        testMarkDickinson(x, y);
        long nano2 = System.nanoTime();
        testHovercraftFullOfEels(x, y);
        long nano3 = System.nanoTime();
        testMrM(x, y);
        long nano4 = System.nanoTime();
        test1nano += nano2 - nano1;
        test2nano += nano3 - nano2;
        test3nano += nano4 - nano3;
    }
    System.out.printf("%11d%n%11d%n%11d%n", test1nano, test2nano, test3nano);
}