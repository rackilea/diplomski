InputStream in = null;
try {
    in = url.openStream();
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    IOUtils.copy(in, buffer);

    ByteArrayInputStream bin = new ByteArrayInputStream(buffer.toByteArray());
    queue.put(bin);
}