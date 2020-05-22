public Container createContainer() {
    final Interface myDependent = new A();
    return new Container(myDependent);
}

public class Container {
     private Interface interface;

     public Container(Interface interface) {
         this.interface = interface;
     }
     ...
}