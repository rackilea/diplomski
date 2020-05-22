for(int i = 0; i < ar.length; i++)
{
  if(ar[i] != null)
    s += ar[i].getTypeName()+"\n";
 for(int j = 1; j < ar.length; j++)
  {
    if(ar[i] != null && ar[j] != null && ar[i].getTypeName().equals(ar[j].getTypeName()))
    {
        duplicate += i+" has the same name as "+j+"\n";
    }
  }
}
System.out.println("These are the roomtypes: \n"+s+"\n");
System.out.println(duplicate);