// ack from client to server
socket.on("foo", new Emitter.Listener() {
  @Override
  public void call(Object... args) {
    Ack ack = (Ack) args[args.length - 1];
    ack.call();
  }
});