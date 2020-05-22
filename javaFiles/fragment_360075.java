InputStream is = new FileInputStream(fileName);
byte[] buffer = new byte[4096];
while (true) {
    int read = is.read(buffer);
    if (read < 0) {
        break;
    }
    md.update(buffer, 0, read);
}
is.close(); // better be done in finally