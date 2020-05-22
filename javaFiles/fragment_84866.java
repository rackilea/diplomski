class Base <T>{ 
  protected abstract void printResults(T abc);
}
...  

class BaseStringImpl<String>{
@Override
  protected void printResults(String abc) {
   ...
  }
}

...
class BaseIntegerImpl<Integer>{
@Override
  protected void printResults(Integer abc) {
   ...
  }
}