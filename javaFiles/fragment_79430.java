abstract class A {
    void doInitialization() {}
}

class B extends A {
    @BeforeClass
    void doSpecificInitialization() {
        super.doInitialization();
    }

    @Test
    void doTests() {}
}