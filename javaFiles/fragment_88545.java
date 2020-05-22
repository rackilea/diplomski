public int hashCode() {
  int hash = 17;
  hash = hash * 31 + k1.hashCode();
  hash = hash * 31 + k2.hashCode();
  hash = hash * 31 + k3.hashCode();
  hash = hash * 31 + k4 ? 0 : 1;
  return hash;
}