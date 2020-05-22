URLConnection conn = new URL("http://www.gravatar.com/avatar/fd9e8761fad999a1bf1e095fc8f53ffe?s=32&d=identicon&r=PG")
            .openConnection();
    InputStream is = conn.getInputStream();
    FileOutputStream outstream = new FileOutputStream("/tmp/myfile");
    byte[] buffer = new byte[4096];
    int len;
    while ((len = is.read(buffer)) > 0) {
        outstream.write(buffer, 0, len);
    }
    outstream.close();
    is.close();