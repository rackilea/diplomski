private boolean isPositive() {
  return sign == 1;
}

private boolean isBiggerThen(BigNumber other) {
  return this.compare(other) > 0;
}