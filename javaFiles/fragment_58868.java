interface Service {
   void doIt();
}

class ServiceImpl implements Service {
  public void doIt() { ... }
}

interface RemoteService extends Remote {
  void proxyDoIt() throws RemoteException;
}

class RemoteServiceHost implements RemoteService {
  public void proxyDoIt() throws RemoteException {
    // serviceImpl is a field, defined in the constructor
    serviceImpl.doIt();
  }
}

class RemoteServiceClient implements Service {
  public void doIt() {
   try {
    // remoteService is a field, defined in the constructor
    remoteService.proxyDoIt();
   } catch (RemoteException e) {
    throw new RuntimeException(e);
   }
  }
}