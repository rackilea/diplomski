public void proxy() {
    ServerSocket s = ...;
    Socket app1 = s.accept();
    Socket app2 = s.accept();
    InputStream app1Input = app1.getInputStream();
    InputStream app2Input = app2.getInputStream();
    OutputStream app1Output = app1.getOutputStream();
    OutputStream app2Output = app2.getOutputStream();

    pipeInToOut(app1Input, app2Output);
    pipeInToOut(app2Input, app1Output);
}

public void pipeInToOut(final InputStream in, final OutputStream out) {
    new Thread() { public void run() {
       byte[] buffer = new byte[2000];
       int r;
       while((r = in.read(buffer) > 0) {
          out.write(buf, 0, r);
       }
    }}.start();
}