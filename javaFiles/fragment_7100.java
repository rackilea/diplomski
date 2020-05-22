import java.util.*;
class hello
{
   public static void main (String[] args) throws java.lang.Exception
   {
     TimeZone tz=TimeZone.getDefault();
     String a[]=tz.getAvailableIDs(21600000);
     for(int i=0;i<a.length;i++)
      System.out.println(a[i]);
  }
}