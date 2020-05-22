try (ZipFile file = new ZipFile("file.zip")) {
    final Enumeration<? extends ZipEntry> entries = file.entries();
    while (entries.hasMoreElements()) {
        final ZipEntry entry = entries.nextElement();
        System.out.println(entry.getName());
    }
}