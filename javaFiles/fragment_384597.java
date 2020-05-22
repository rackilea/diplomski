Future<SQLConnection> tConResultFuture = Future.future();
tdbClient.getConnection(tConresult -> {
  if (tConresult.succeeded()) {
    logger.info("Yeah got a connection! tCon");
    tConResultFuture.complete(tConresult.result());
  } else {
    tConResultFuture.fail(tConresult.cause());
  }
});