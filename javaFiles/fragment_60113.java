public class Record {
  Object id; // some sort of unique identifier
  Map<String, String> values; // all key/values of a single row
  public Record(Object id) {this.id=id;}
  public void put(String key, String value){
    values.put(key, value);
  }
  public void get(String key) {
    values.get(key);
  }
}