public class SuperTestClass<E> {

  private final Class<E> genericClass;

  public SuperTestClass(Class<E> genericClass) {
    this.genericClass = genericClass;
  }

  // Changed return type
  public Class<E> getClassType() {
    return this.genericClass;
  }
}


// Subclass
public class TestClass extends SuperTestClass<Connection> {

    public TestClass() {
        super(Connection.class);
    }

}