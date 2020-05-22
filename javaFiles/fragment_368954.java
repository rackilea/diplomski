URL url;

void setup() {
    try {
        url = new URL("http://www.google.com");
    } catch (MalformedURLException ex) {
        throw new RuntimeException(ex);
    }
}