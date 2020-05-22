@Override
public boolean equals(Object obj) {
  if (obj instanceof Order) {
    if (id == null) {
      // return ((Order) obj).id == null;
      return false; // probably best to prevent null
    }
    return id.equals(((Order) obj).id);
  }
  return false;
}

@Override
public int hashCode() {
  return id.hashCode();
}