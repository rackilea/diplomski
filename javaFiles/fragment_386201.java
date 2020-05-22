class Animal{
  public void speak(){ System.out.println("Speaking something");}
}

class Person extends Animal{
 @Override
 public void speak(){ System.out.println("Hello..");}
}