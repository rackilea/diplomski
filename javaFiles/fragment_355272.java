Socket sock = new Socket();
doSomething(sock);
...
public void doSomething(Socket sock) {
    sock.connect(new InetSocketAddress("foo.com", 6667));
}