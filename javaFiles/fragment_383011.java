// assuming folder structure exists.
public void readImage(Socket s, File to) throws IOException {

    DataInputStream dis = new DataInputStream(s.getInputStream());
    char c = dis.readChar();
    if (c == 'I') {
        long length = dis.readLong();
        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(to));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = dis.read(buffer)) != -1) {
            dos.write(buffer, 0, len);
        }
        dis.close();
        dos.close();
    }

}