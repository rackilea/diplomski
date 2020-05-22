new SocketEsp(MainActivity.this, "10.1.1.105",6000).execute();

SocketEsp(Context context, String addr, int port) {
    this.context = context;
    dstAddress = addr;
    dstPort = port;
}