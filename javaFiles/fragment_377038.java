private Lock playerLock = new ReentrantLock();
private Condition[] playerConditions = { playerLock.newCondition(), playerLock.newCondition() };

// Later on:
while (data.matchesAmount != 0) {
  while (number != data.which) {
    playerConditions[number].await();
  }
  // do work here

  // now release the other player -- this assumes there are only 2
  data.which = 1 - number;
  playerConditions[1 - number].signalAll();
}