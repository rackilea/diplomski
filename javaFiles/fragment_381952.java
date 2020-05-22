class Service extends UnicastRemoteObject  implements MyInterface {
   public Service() {
   }
   public MyClass f(MyClass v) throws RemoteException {
       return new MyClass(v.getValue() + 1)
   }

   public static void main(Strint arg[]) {
      Registry r = LocateRegistry.createRegistry(1099);
      r.rebind("service", new Service());
   }
}