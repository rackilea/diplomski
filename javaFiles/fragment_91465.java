Socket s = new Socket();
SocketAddress a = new InetSocketAddress("www.google.com", 80);
int timeoutMillis = 2000;
long start = System.currentTimeMillis();
try {
    s.connect(a, timeoutMillis);
} catch (SocketTimeoutException e) {
    // timeout
} catch (IOException e) {
    // some other exception
}
long stop = System.currentTimeMillis();
times.add(stop - start);
try {
    s.close();
} catch (IOException e) {
    // closing failed
}