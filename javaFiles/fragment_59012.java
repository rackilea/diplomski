interface Foo{
  double calculateStuff();
}

class MyClass implements Foo{
  @Override
  public double calculateStuff(){
    //logic goes here
  }
}

class MyFactory {
  public static double getCalculatedStuff(){
    return new MyClass().calculateStuff();
  }
}

class RunCode {
  public static void main(String[] args){
     double stuff = MyFactory.getCalculatedStuff();
  }
}