server.addListener(new Listener() {
   @Override
   public void connected(Connection connection) {
      // 44 is the identifier of the JemmyCommander, referenced by a client
      new ObjectSpace(connection).register(44, new JemmyCommander());
   }
});