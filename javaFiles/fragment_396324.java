@Rule
public TestRule testWatcher = new TestWatcher() {
    @Override
    public void failed(Throwable t, Description test) {
        takeScreenshot("some name");
    }
};