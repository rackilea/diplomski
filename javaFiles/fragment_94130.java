InputStream in = proc.getInputStream();  // To read process standard output
InputStream err = proc.getErrorStream(); // To read process error output

while (proc.isAlive()) {
    while (in.available() > 0)
        in.read(); // You might wanna echo it to your console to see progress

    while (err.available() > 0)
        err.read(); // You might wanna echo it to your console to see progress

    Thread.sleep(1);
}