//This method prints out the even indexes of a string
public static String decrypt(String question, Scanner console)
{
  String str = "";
  System.out.print(question + " ");
  String s = console.nextLine();
  for (int i = 0; i < s.length(); i=i+2)
  {
     char x = (s.charAt(i));
     str  = str + String.valueOf(x);

  }
return str;
}