public class UrlFactory {
    public URLConnection fetchConnection(String url)
        throws IOException {
        URL address = new URL(url);
        return address.openConnection();
    }
}

public class MockUrlFactory extends UrlFactory {
    private long testDate;

    public MockUrlFactory(long testDate) {
        this.testDate = testDate;
    }

    public URLConnection fetchConnection(String url)
        throws IOException {
        URL address = new URL(url);
        return new MockURLConnection(address, testDate);
    }
}