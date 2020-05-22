interface MyService extends RemoteService {
  SomeData getPublicData();
  SomeSecret getPrivateData() throws AccessDeniedException; 
  Result login(String username, String password);
}

interface MyServiceAsync {
  void getPublicData(AsyncCallback<SomeData> callback);
  void getPrivateData(AsyncCallback<SomeSecret> callback);
  void login(String username, String password, AsyncCallback<Result> callback);
}