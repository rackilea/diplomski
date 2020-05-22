class MethodsTest {

    @TestFactory
    Iterator<DynamicTest> flat() {
        return FlatTestScanner.scan(this);
    }

    @Test
    void rootTest() {
    }

    @FlatTest
    static class singleTestClass implements TestClass {
        void run() {
            // ...
        }
    }

    static class Whatever {
        @FlatTest
        void multiTestClass_1() {
            // ...
        }

        @FlatTest
        void multiTestClass_2() {
            // ...
        }
    }
}