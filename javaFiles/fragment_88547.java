public int hashCode() {
  int hash = 17;
  hash = hash * 31 + ObjectUtil.hashCode(k1);
  hash = hash * 31 + ObjectUtil.hashCode(k2);
  hash = hash * 31 + ObjectUtil.hashCode(k3);
  hash = hash * 31 + k4 ? 0 : 1;
  return hash;
}