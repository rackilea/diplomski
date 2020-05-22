String s =  "aa;bbbb/";
Matcher m = Pattern.compile("[;/)]").matcher(s);   // [;/)] would match a forward slash or semicolon or closing bracket.
if(m.find())                                       // if there is a match found, note that it would find only the first match because we used `if` condition not `while` loop.
{
    System.out.println(m.start());                 // print the index where the match starts.

}
else
{
    System.out.println("-1");                      // else  print -1
}