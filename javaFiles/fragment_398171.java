File directory = new File("/path/to/dir");
File[] files = directory.listFiles();
if (files != null) { // 'files' can be null if 'directory' "does not denote a directory, or if an I/O error occurs."
    // use the 'files' array or convert to a stream:
    Stream<File> fileStream = Arrays.stream(files);
}