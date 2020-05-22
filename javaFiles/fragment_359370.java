interface YourInterface {
  void save();
}

interface Request<E extends YourInterface> { 
  E getValue(); 
} 

class DataStore<E extends YourInterface> {
  public void save(Request<E> r) {
    r.getValue().save();
  }
}