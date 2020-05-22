h = t.getResponseHeaders();
os = t.getResponseBody();

// Get an URL to the file
URL url = getClass().getResource("GreetingText.html");

// Open the stream and read the contents into a byte array
byte[] bytes;
try(InputStream in = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream()) {
    byte[] buffer = new byte[1024];
    int read;
    while((read = in.read(buffer)) > 0) {
        bytes.write(buffer, 0, read);
    }
    bytes = out.toByteArray();
}

h.add("Content-Type", "text/html");
t.sendResponseHeaders(200, bytes.length);
os.write(bytes, 0, bytes.length);
os.close();