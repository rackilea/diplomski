out = new PrintWriter(client.getOutputStream(), true);
in = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
char[] buf = new char[4096];
int size = 0;
while((size = in.read(buf)) != -1) {
    String someString = new String(buf, 0, size);
    delegate.didReadData(this, someString);
}