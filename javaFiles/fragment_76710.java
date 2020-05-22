public runningMethod(){
    Process p = exec("java HelloWorld", null, new File("C:/"));
    pipe(p.getInputStream(), new FileOutputStream("C:/test.txt"));
}

public void pipe(InputStream in, OutputStream out) {
    byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
    int writtenBytes;
    while((writtenBytes = in.read(buf)) >= 0) {
        out.write(buf, 0, writtenBytes);
    }
}