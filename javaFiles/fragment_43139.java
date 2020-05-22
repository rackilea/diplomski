byte[] buff = new byte[64*1024]; //or some size, can try out different sizes for performance
    BufferedInputStream in = new BufferedInputStream(new FileInputStream("fromFile"));
    BufferedOutputStream out = new BufferedOutputStream(new FileoutputStream("toFile"));
    int n = 0;
    while ((n = in.read(buff)) >= 0) {
        out.write(buff, 0, n);
    }
    in.close();
    out.close();