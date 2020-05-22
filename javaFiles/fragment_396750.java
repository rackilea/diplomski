private static class TrainComposition {

  private final Deque<Integer> wagons = new LinkedList<>();

  public void attachLeft(int wagonNumber) {
    wagons.addFirst(wagonNumber);
  }

  public void attachRight(int wagonNumber) {
    wagons.addLast(wagonNumber);
  }

  public void detachLeft() {
    if (!wagons.isEmpty()) {
      wagons.removeFirst(); // Alternative if exception should not be bubbled up: wagons.pollFirst()
    } else {
      throw new IndexOutOfBoundsException("No wagons available");
    }
  }

  public void detachRight() {
    if (!wagons.isEmpty()) {
      wagons.removeLast(); // Alternative if exception should not be bubbled up: wagons.pollLast()
    } else {
      throw new IndexOutOfBoundsException("No wagons available");
    }
  }
}