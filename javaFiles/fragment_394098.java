FileInputStream source = null;
FileOutputStream destination = null;
try {
    source = new FileInputStream(new File(/*...*/));
    destination = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), /*...*/);
    IOUtils.copy(source, destination);
} finally {
    IOUtils.closeQuietly(source);
    IOUtils.closeQuietly(destination);
}