try {
    StudentService obj = new StudentService();
    UnicastRemoteObject.exportObject(obj, 0);

    Registry r = LocateRegistry.createRegistry(4200);
    r.bind("localhost", obj);

} catch (RemoteException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (AlreadyBoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}