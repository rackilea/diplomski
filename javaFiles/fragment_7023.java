public class HelloWorld
{
  public static void main(String[] args)
  {
    String s = "    Hello I'm a       multi spaced String";
    s = s.replaceAll("\\s{2,}","%temp%");
    System.out.println(s);
  }
}