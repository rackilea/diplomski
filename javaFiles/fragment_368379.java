final Tcp tcp = Tcp.get(system);
tcp.bind("127.0.0.1", 6789).runForeach((connection) -> {

  final Flow<ByteString, ByteString, NotUsed> echo = Flow.of(ByteString.class)
    .via(Framing.delimiter(ByteString.fromString("\n"), 256, FramingTruncation.DISALLOW))
    .map(ByteString::utf8String)
    .map(s -> s + "!!!\n")
    .map(ByteString::fromString)
    .watchTermination((notUsed, completionStage) -> {
      completionStage.whenComplete((done, exception) -> {
        System.out.println("Connection from " + connection.remoteAddress() + " completed");
      });
      return notUsed;
    });

  connection.handleWith(echo, materializer);
}, materializer);