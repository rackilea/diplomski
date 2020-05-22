public boolean equals(java.lang.Object ts) {
  if (ts instanceof Timestamp) {
    return this.equals((Timestamp)ts);
  } else {
    return false;
  }
}