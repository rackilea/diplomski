public void send(String m) throws IOException {
    this.pipe.getWriter().write(m);
    this.pipe.getWriter().write(0);
    this.pipe.getWriter().flush();
}

public void receive() throws IOException {
    while(true) {
        int data = this.pipe.getReader().read();
        if (data == 0) break;
        System.out.print((char) data);
    }
    System.out.println();
}

public void receive(String m) throws IOException {
    for (int i = 0; i < m.length(); i++) {
        System.out.print((char) this.pipe.getReader().read());
    }
    this.pipe.getReader().read(); // consume the terminator
    System.out.println();
}