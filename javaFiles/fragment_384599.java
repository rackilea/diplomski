CompositeFuture.all(tConResultFuture, sConResultFuture).setHandler(connections -> {
  if (connections.succeeded()) {
    logger.info("Both connections are ready for use!");

    SQLConnection tCon = tConResultFuture.result();
    SQLConnection sCon = sConResultFuture.result();

    // do stuff...
  } else {
    logger.severe("Both or one connections attempt failed!");
  }
});