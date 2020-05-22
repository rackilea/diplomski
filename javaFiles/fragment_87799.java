new Comparator<Card>() {
  @Override
  public int compare(Card x, Card y) {
    return x.getValue().compareTo(y.getValue());
  }
}