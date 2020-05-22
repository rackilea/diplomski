bStream = new BufferedInputStream(new FileInputStream(file));
byte[] bytes = new byte[4096];
int read;
while ((read = bStream.read(bytes)) > 0) {
    // do these new bytes match the pattern I'm looking for
    // accounting for boundaries, etc
}