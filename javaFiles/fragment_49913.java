public int compareTo(Custom o) {
  int ret = this.rank - o.rank;

  // Equal rank so fall back to comparing by name.
  if (ret == 0) {
    ret = this.name.compareTo(o.name);
  }

  return ret;
}