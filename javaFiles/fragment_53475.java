private void writeMimeType(ZipOutputStream zip) throws IOException {
    byte[] content = "application/epub+zip".getBytes("UTF-8");
    ZipEntry entry = new ZipEntry("mimetype");
    entry.setMethod(ZipEntry.STORED);
    entry.setSize(20);
    entry.setCompressedSize(20);
    entry.setCrc(0x2CAB616F); // pre-computed
    zip.putNextEntry(entry);
    zip.write(content);
    zip.closeEntry();
}