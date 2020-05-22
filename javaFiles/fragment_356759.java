@BeforeSuite
public void deactivateCertChecker() {
    new MockUp<ClassLoader>() {
        @Mock
        void checkCerts(final String name, final CodeSource cs) {}
    };
}