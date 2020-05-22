public class Shape{
   public void methodA{
     System.out.println("Hello!");
  }

  public abstract void methodB();
}

public class Square extends Shape{
   public void methodB{
     System.out.println("I'm a Square!);
  }
}