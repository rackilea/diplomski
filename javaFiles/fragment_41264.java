class Node <T0 extends OutputStream, T1 extends InputStream> {

  T0 to;


  Node(T0 to) {
    this.to = to;
  }

  T0 write(T1 x) throws IOException {
    to.write(x.read());
    return to;
  }

}