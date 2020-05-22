String str = "TOK3 TOK1 TOK2 TOK2 TOK4 TOK3";
String[] arr = str.split(" "); // maybe consider using \\s or \\s+ instead
int start = -1;
String match = "";
for (int i = 0; i < arr.length; i++)
{
   if (arr[i].matches("(TOK1|TOK2)"))
   {
      if (start == -1)
         start = i;
      match += ((match.length() != 0) ? " " : "") + arr[i];
   }
   else if (start != -1)
   {
      System.out.println(match);
      System.out.println("start = " + start);
      System.out.println("finish = " + i);
      match = "";
      start = -1;
   }
}