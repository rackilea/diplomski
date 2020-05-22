if (isPositive() && other.isPositive()) {
  if (this.isBiggerThen(other)) {
    return this.plus(other);
  } else {
    return other.plus(this);
  }
}