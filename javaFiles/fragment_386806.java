Scanner scanner = new Scanner(System.in);
String s = scanner.nextLine();

isletter(s);  // a call to the function


// function
public void isletter(String s)
{

for (int i = 0; i < s.length(); i++)
{
      if (isLetter(s.charAt(i) ) )
    System.out.println(s.charAt(i));

   else System.out.println(""); 


}