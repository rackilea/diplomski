public run() {
  ...
  Random random = new SecureRandom();

  while ( < 60 minutes) {
    double randomNumber = random.nextDouble() * 100.0;
    ReadTableConnectionInfo tableInfo = selectRandomConnection(randomNumber);

    // do query...
  }
}


private ReadTableConnectionInfo selectRandomConnection(double randomNumber) {
  double limit = 0;
  for (ReadTableConnectionInfo ci : tableLists.values()) {
    limit += ci.getPercentage();
    if (randomNumber < limit) {
      return ci;
  }
  throw new IllegalStateException();
}