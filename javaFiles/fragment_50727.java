class StackImplementation {
  public void foo () {
    Stack abc =new Stack(5);
    boolean value = abc.isEmpty();
    if(value)
      {
         System.out.println("Yes it's empty");
      }
    abc.push(22);
    abc.push(23);
 }
}