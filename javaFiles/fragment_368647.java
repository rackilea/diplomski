public String getFileContentsAsString(final File pZipFile, final String pFileName) throws Exception {

    try (ZipFile zipFile = new ZipFile(pZipFile)) {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry currentEntry = entries.nextElement();
            if (matchesDesiredFile(pFileName, currentEntry)) {
                try (InputStream entryIn = zipFile.getInputStream(currentEntry)) {
                    String text = IOUtils.toString(entryIn, Charsets.UTF_8);
                    return text;
                }
            }
        }
    }

    return null;
}

private boolean matchesDesiredFile(final String pFileName, final ZipEntry pZipEntry) {
    return !pZipEntry.isDirectory() && pZipEntry.getName().equals(pFileName);
}