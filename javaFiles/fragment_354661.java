Map<Integer, Integer> hashes = new HashMap<> ();
Map<Integer, Integer> dupes = new HashMap<> ();
int i = 0;
while ((line = buff.readLine()) != null) {
  int hash = line.hashCode();
  Integer previous = hashes.get(hash);
  if (previous != null) { //potential duplicate
    dupes.put(i, previous);
  } else {
    hashes.put(hash, i);
  }
  ++i;
}