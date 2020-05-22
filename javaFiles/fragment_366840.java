try {
    this.sock = new Socket(this.ipaddr, this.portnum);
    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
    output.println(this.name);
} catch (UnknownHostException e) {
    System.err.println("Problem at ip: " + this.ipaddr);
    System.exit(1);
}
// this.sock should still be open at this point.