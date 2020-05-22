class Test {
    public static long staticAtr = System.currentTimeMillis();
    public long nonStaticAtr = System.currentTimeMillis();

    public static void main(String[] args) {

        Test t1 = new Test();
        Thread.sleep(100);
        Test t2 = new Test();
        System.out.println(t1.staticAtr);
        System.out.println(t1.nonStaticAtr);
        System.out.println(t2.staticAtr);
        System.out.println(t2.nonStaticAtr);
}