class TestStackWalker {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        try {
            test1.test();
        } catch (Exception e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
        }
    }
}