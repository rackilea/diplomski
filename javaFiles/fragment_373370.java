public static void main_other(String s)
{
    s = s.toUpperCase();
    char c[] = {'A', 'E', 'I', 'O', 'U'};
    String a = "";
    outerloop:
    for(int i = 0; i < s.length(); i++)
    {
        for(int j = 0; j < 5; j++)
        {
           if(s.charAt(i) == c[j])
           {
               a = s.substring(i) + s.substring(0, i) + "AY";
               break outerloop;
           }
        }
   }
   System.out.println("Piglatin:"+a);
}