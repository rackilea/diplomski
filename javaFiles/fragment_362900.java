BufferedOutputStream out = null;
try {
    out = new BufferedOutputStream(new FileOutputStream("/home/wemohamm/Desktop/test.zip"), 4096);
    out.write(byteArray);
} finally {
    if (out != null) {
        out.close();
    }
}