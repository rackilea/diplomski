class Client {
       public static void main(Strint arg[]) {
          Registry r = LocateRegistry.getRegistry("localhost", 1099);
          MyInterface service = (MyInterface)r.lookup("service");

          MyClass result = service.f(new MyClass(123));
          System.out.println(result.getValue());  //print 124 here
       }
  }