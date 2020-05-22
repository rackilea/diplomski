class MyTest implements BooleanTest {
    private boolean result;
    public MyTest(int a, int b, int c) {
        result = a + b == c;
    }
    // stupid test -- don't _have_ to declare "throws Exception"
    public boolean test(Object... args) {
        return result && args.length == 3;
    }
}

TEST(new MyTest(1, 2, 3));