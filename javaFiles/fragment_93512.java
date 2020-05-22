try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
    try ((ZipOutputStream zout = new ZipOutputStream(bos)) {
        zipSubDirectory("", dir, zout);
    }
    return bos.toByteArray();
} catch (IOException e) {
    throw new RuntimeException(e);
}