while (!list.isEmpty()) {
  phaser.arriveAndAwaitAdvance();
  System.out.println(list.remove(0));
  phaser.arriveAndAwaitAdvance();
}
phaser.arriveAndDeregister();