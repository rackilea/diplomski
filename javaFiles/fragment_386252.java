public abstract class Abstract{
  /** Do the class-specific behavior you want to do currently in func */
  public abstract void operation();

  public static void func(Abstract a){
    a.operation();
  }
}