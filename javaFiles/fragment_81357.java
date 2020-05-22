try (DataInputStream ds = new DataInputStream(new FileInputStream("dummy.txt"));
        Writer bw = new BufferedWriter(new FileWriter("out_writer.txt"))) {
    String l;
    while ((l = ds.readLine()) != null) {
        bw.write(l);
    }
}
try (InputStream in = new FileInputStream("dummy.txt");
        OutputStream out = new FileOutputStream("out_inputstream.txt")) {
    byte[] buffer = new byte[8192];
    int readBytes = -1;
    while ((readBytes = in.read(buffer)) > -1) {
        out.write(buffer, 0, readBytes);
    }
}