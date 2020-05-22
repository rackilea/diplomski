@BeforeClass
public static void fakeCurrentYear() {
    new MockUp<MyClass>() {

        @Mock 
        public int currentYear4digits() {
            return 2016;
        }
    };
}