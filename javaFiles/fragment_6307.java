@RemoteServiceRelativePath("getObjects")
public interface TableService extends RemoteService {
    List<Customer> getObjects(String[] ids);
}

public interface TableServiceAsync {
    void getObjects(String[] ids, AsyncCallback <List<Customer>> callback);
}