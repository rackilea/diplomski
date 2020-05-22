byte[] bytes = new byte[4096];
OutputStream bout = new ByteArrayOutputStream(bout);
PrintWriter out = new PrintWriter(
    new OutputStreamWriter(bout,"UTF-8"));
out.println("simpleString);
out.close();