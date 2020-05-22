static final Map<Integer, String> CONSTANT_MAP;
static {
  Map<Integer, String> tmp = new LinkedHashMap<Integer, String>();
  tmp.put(1, "one");
  tmp.put(2, "two");
  CONSTANT_MAP = Collections.unmodifiableMap(tmp);
}