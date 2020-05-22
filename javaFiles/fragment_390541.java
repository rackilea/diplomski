@Override public boolean equals(Object obj) {
  if (!(obj instanceof ProbabilityIndex)) return false;
  if (obj == this) return true;
  ProbabilityIndex rhs = (ProbabilityIndex) obj;
  return this.trueLabel == rhs.trueLabel
      && this.classifiedLabel ==  rhs.classifiedLabel
      && this.classifierIndex == rhs.classifierIndex;
}

@Override public int hashCode() {
  return trueLabel | (classifiedLabel << 1) | (classifierIndex << 2);
}