socket = IO.socket("http://192.168.1.103:2731");
socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

  @Override
  public void call(Object... args) {
      JSONObject intro = new JSONObject();
      intro.put("type","android");
      intro.put("id",7);
      socket.emit("intro");
  }
};
socket.connect();