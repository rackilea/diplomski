public void receive() throws IOException {

    while(this.pipe.getReader().ready()) {
        int data = this.pipe.getReader().read();
        System.out.print((char) data);
    }
    System.out.println();
}