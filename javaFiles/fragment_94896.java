public class MyClass
{
  private static MyFileWriter x;

  static {
    try {
      x = new MyFileWriter("foo.txt"); 
    } catch (Exception e) {
      logging_and _stuff_you_might_want_to_terminate_the_app_here_blah();
    } // end try-catch
  } // end static init block
  ...
}