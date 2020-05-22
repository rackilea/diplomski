/*
 * Note that all access through the filter reference the underlying Map so
 * adding to a MapFilder results in additions to the Map.
 */
public class MapFilter<T> implements Map<String, T> {
  // The enclosed map -- could also be a MapFilter.
  final private Map<String, T> map;
  // Use a TreeMap for predictable iteration order.
  // Store Map.Entry to reflect changes down into the underlying map.
  // The Key is the shortened string. The entry.key is the full string.
  final private Map<String, Map.Entry<String, T>> entries = new TreeMap<String, Map.Entry<String, T>>();
  // The prefix they are looking for in this map.
  final private String prefix;

  public MapFilter(Map<String, T> map, String prefix) {
    // Store my backing map.
    this.map = map;
    // Record my prefix.
    this.prefix = prefix;
    // Build my entries.
    rebuildEntries();
  }

  public MapFilter(Map<String, T> map) {
    this(map, "");
  }

  private synchronized void rebuildEntries() {
    // Start empty.
    entries.clear();
    // Build my entry set.
    for (Map.Entry<String, T> e : map.entrySet()) {
      String key = e.getKey();
      // Retain each one that starts with the specified prefix.
      if (key.startsWith(prefix)) {
        // Key it on the remainder.
        String k = key.substring(prefix.length());
        // Entries k always contains the LAST occurrence if there are multiples.
        entries.put(k, e);
      }
    }

  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("MapFilter (" + prefix + ") of " + map + " containing ").append(entrySet());
    return s.toString();
  }

  // Constructor from a properties file.
  public MapFilter(Properties p, String prefix) {
    // Properties extends HashTable<Object,Object> so it implements Map.
    // I need Map<String,T> so I wrap it in a HashMap for simplicity.
    this(new HashMap<String, T>((Map) p), prefix);
  }

  // Helper to fast filter the map.
  public MapFilter<T> filter(String prefix) {
    // Wrap me in a new filter.
    return new MapFilter<T>(this, prefix);
  }

  // Count my entries.
  public int size() {
    return entries.size();
  }

  // Are we empty.
  public boolean isEmpty() {
    return entries.isEmpty();
  }

  // Is this key in me?
  public boolean containsKey(Object key) {
    return entries.containsKey(key);
  }

  // Is this value in me.
  public boolean containsValue(Object value) {
    // Walk the values.
    for (Map.Entry<String, T> e : entries.values()) {
      if (value.equals(e.getValue())) {
        // Its there!
        return true;
      }
    }
    return false;
  }

  // Get the referenced value - if present.
  public T get(Object key) {
    return get(key, null);
  }

  // Get the referenced value - if present.
  public T get(Object key, T dflt) {
    Map.Entry<String, T> e = entries.get((String)key);
    return e != null ? e.getValue() : dflt;
  }

  // Add to the underlying map.
  public T put(String key, T value) {
    T old = null;
    // Do I have an entry for it already?
    Map.Entry<String, T> entry = entries.get(key);
    // Was it already there?
    if (entry != null) {
      // Yes. Just update it.
      old = entry.setValue(value);
    } else {
      // Add it to the map.
      map.put(prefix + key, value);
      // Rebuild.
      rebuildEntries();
    }
    return old;
  }

  // Get rid of that one.
  public T remove(Object key) {
    // Do I have an entry for it?
    Map.Entry<String, T> entry = entries.get((String)key);
    if (entry != null) {
      entries.remove(key);
      // Change the underlying map.
      return map.remove(prefix + key);
    }
    return null;
  }

  // Add all of them.
  public void putAll(Map<? extends String, ? extends T> m) {
    for (Map.Entry<? extends String, ? extends T> e : m.entrySet()) {
      put(e.getKey(), e.getValue());
    }
  }

  // Clear everything out.
  public void clear() {
    // Just remove mine. This does not clear the underlying map.
    for (String key : entries.keySet()) {
      map.remove(prefix + key);
    }
    entries.clear();
  }

  public Set<String> keySet() {
    return entries.keySet();
  }

  public Collection<T> values() {
    // Roll them all out into a new ArrayList.
    List<T> values = new ArrayList<T>();
    for (Map.Entry<String, T> v : entries.values()) {
      values.add(v.getValue());
    }
    return values;
  }

  public Set<Map.Entry<String, T>> entrySet() {
    // Roll them all out into a new TreeSet.
    Set<Map.Entry<String, T>> entrySet = new TreeSet<Map.Entry<String, T>>();
    for (Map.Entry<String, Map.Entry<String, T>> v : entries.entrySet()) {
      entrySet.add(new Entry<T>(v));
    }
    return entrySet;
  }

  /**
   * An entry.
   *
   * @param <T>
   *
   * The type of the value.
   */
  private static class Entry<T> implements Map.Entry<String, T>, Comparable<Entry<T>> {
    // Note that entry in the entry is an entry in the underlying map.
    private final Map.Entry<String, Map.Entry<String, T>> entry;

    Entry(Map.Entry<String, Map.Entry<String, T>> entry) {
      this.entry = entry;
    }

    public String getKey() {
      return entry.getKey();
    }

    public T getValue() {
      // Remember that the value is the entry in the underlying map.
      return entry.getValue().getValue();
    }

    public T setValue(T newValue) {
      // Remember that the value is the entry in the underlying map.
      return entry.getValue().setValue(newValue);
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Entry)) {
        return false;
      }
      Entry e = (Entry) o;
      return getKey().equals(e.getKey()) && getValue().equals(e.getValue());
    }

    @Override
    public int hashCode() {
      return getKey().hashCode() ^ getValue().hashCode();
    }

    @Override
    public String toString() {
      return getKey() + "=" + getValue();
    }

    public int compareTo(Entry<T> o) {
      return getKey().compareTo(o.getKey());
    }
  }

  // Simple tests.
  public static void main(String[] args) {
    String[] samples = {
      "Some.String.For.Me",
      "Some.String.For.You",
      "Some.More",
      "Yet.More"};
    Map map = new HashMap();
    for ( String s : samples ) {
      map.put(s, s);
    }
    Map all = new MapFilter(map);
    Map some = new MapFilter(map, "Some.");
    Map someString = new MapFilter(some, "String.");
    System.out.println("All: "+all);
    System.out.println("Some: "+some);
    System.out.println("Some.String: "+someString);
  }


}