class Base{ 
  protected abstract void printResults(Object abc);
}
...  
class BaseImpl{
@Override
  protected void printResults(String abc) {
    ...
  }
}