public class Triple<K, V1, V2> {

  private K key;
  private V1 value1;
  private V2 value2;

  public Triple(K a, V1 value1, V2 value2) {
    this.key = a;
    this.value1 = value1;
    this.value2 = value2;
  }

  public K getKey() {
    return key;
  }

  public V1 getValue1() {
    return value1;
  }

  public V2 getValue2() {
    return value2;
  }
}