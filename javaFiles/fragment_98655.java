public interface IMyDao {
    List<String> getAllObject();
}

public class MyDao implements IMyDao {
    public List<String> getAllObject() {
        List<String> os = new ArrayList<String>();
        // DB access or Datastore (Sample code)
        os = datastore.query(...);
        return os;
    }
}