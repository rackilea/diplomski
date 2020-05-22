// in is the inputstream that you got from the Uri
// dst is a file to your app internal cache
public void copy(Uri uri, File dst) throws IOException {
    InputStream in = contentResolver.openInputStream(uri);
    OutputStream out = new FileOutputStream(dst);

    // Transfer bytes from in to out
    byte[] buf = new byte[1024];
    int len;
    while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
    }
    in.close();
    out.close();
}