interface MyInterface extends Remote {
  MyClass f(MyClass x) throws RemoteException;
}

class MyClass implements Serializable {
   private int value;
   public MyClass(int value) {
       this.value = value;
   }

   public int getValue() {
       return value;
   }
}