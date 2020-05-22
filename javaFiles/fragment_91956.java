ByteArrayOutputStream output = new ByteArrayOutputStream();

try (InputStream input = new URL("http://example.com/some.jpg").openStream()) {
    byte[] buffer = new byte[10240];
    for (int length = 0; (length = input.read(buffer)) > 0;) {
         output.write(buffer, 0, length);
    }
}

String hex = DatatypeConverter.printHexBinary(output.toByteArray());
// ...