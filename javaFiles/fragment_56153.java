public Server send(String message) throws IOException {
  sessions.parallelStream()
          .map(Session::getBasicRemote)
          .forEach(basic -> Exceptional.from(() -> basic.sendText(message)).get());
  return this;
}