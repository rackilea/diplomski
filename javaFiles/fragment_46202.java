URL url = new URL("https://test.domain.com/a/b/c.html?test=hello");
String protocol = url.getProtocol();
String host = url.getHost();
int port = url.getPort();

// if the port is not explicitly specified in the input, it will be -1.
if (port == -1) {
    return String.format("%s://%s", protocol, host);
} else {
    return String.format("%s://%s:%d", protocol, host, port);
}