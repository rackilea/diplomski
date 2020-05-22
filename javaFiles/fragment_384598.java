Future<SQLConnection> sConResultFuture = Future.future();
sdbClient.getConnection(sConresult -> {
  if (sConresult.succeeded()) {
    logger.info("Yeah got a connection! sCon");
    sConResultFuture.complete(sConresult.result());
  } else {
    sConResultFuture.fail(sConresult.cause());
  }
});