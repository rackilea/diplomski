interface YourInterface {
  String serialize();
}

interface Request<E extends YourInterface> { 
  E getValue(); 
} 

class DataStore<E extends YourInterface> {
  public void save(Request<E> r) {
    String value = r.getValue().serialize();
    // Now do something with value to save to a datastore
  }
}