BufferedReader in
   = new BufferedReader(new FileReader("foo.txt"));

List<String> allStrings = new ArrayList<String>();
String str ="";
while(true)
{
    String tmp = in.readLine();
    if(tmp.isEmpty())
    {
      if(!str.isEmpty())
      {
          allStrings.add(str);
      }
      str= "";
    }
    else if(tmp==null)
    {
        break;
    }
    else
    {
       if(str.isEmpty())
       {
           str = tmp;
       }
       else
       { 
           str += "\\n" + tmp;
       }
    }
}