@Override
public boolean equals(Object x) {
  if (!(x instanceof Arc)) return false;
  Arc that = (Arc) x;
  return this.i == that.i && this.j == that.j;
}

@Override
public int hashCode() {
  return this.i + 31*this.j;
}