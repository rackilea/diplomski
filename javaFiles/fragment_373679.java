while (!list.isEmpty()) {
  System.out.println(list.remove(0));
  phaser.arriveAndAwaitAdvance();
  phaser.arriveAndAwaitAdvance();
}
phaser.arriveAndDeregister();