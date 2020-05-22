public class HelloWorld
{
  public static boolean filter(String test, String filter) {
    for(int i = 0; i < test.length(); i++) {
        if (filter.indexOf(test.charAt(i)) == -1) {
            return false;
        }
    }
    return true;
  }
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    System.out.println(filter("XDQX", "XDQ"));
  }
}