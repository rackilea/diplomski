public  class TripleList<K, V1, V2> implements Iterable<Triple<K, V1, V2>> {

    private List<Triple<K, V1, V2>> triples = new ArrayList<>();

    public void add(K key, V1 value1, V2 value2) {
      triples.add(new Triple<>(key, value1, value2));
    }

    @Override
    public Iterator<Triple<K, V1, V2>> iterator() {
      return triples.iterator();
    }
  }