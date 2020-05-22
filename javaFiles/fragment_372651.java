public abstract class Person<T, U extends Exception> { 
  protected abstract void workWith(T t) throws U;
}

class Developer extends Person<Computer, DeveloperException> {
  protected void workWith(Computer c) throws DeveloperException {
    //implementation code
  }
}