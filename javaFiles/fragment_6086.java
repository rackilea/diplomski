public class HashtableWithPlurals extends Hashtable {

  /** Make the table map both key and key + "s" to value. **/
  public Object put(Object key, Object value) {
    super.put(key + "s", value);
    return super.put(key, value);
  }
}