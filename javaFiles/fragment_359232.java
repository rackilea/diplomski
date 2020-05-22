import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;;
class Anagrams
{
    int c = 0;
    LinkedList<String> ls = new LinkedList<String>();
    LinkedList<String> ls1 = new LinkedList<String>(); 
    void input()throws Exception
    {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter Word:");
      String s = sc.next();
      System.out.println("The Anagrams are : ");
      display("",s);
      getString(ls.getFirst());
      System.out.println(ls1);
      System.out.println("Total Number of Anagrams = "+c);
    }

    void display(String s1, String s2)
    {
       if(s2.length() == 1) { 
         ls.add(s1+s2);
         c++;
       }else {
         for(int i = 0; i<s2.length(); i++) {
           String x = s2.substring(i,i+1);
           String y = s2.substring(0,i);
           String z = s2.substring(i+1);
           display(s1+x, y+z);
         }
       }
    }

    void getString(String str ) {
        if(ls.size() == 0) {
          return;
        }
        if(ls1.size() == 0) {
          ls1.add(str);
          ls.remove(str);
        }

        // Rearrange the linked list
        for (String str1 : ls) {
          if(str.charAt(str.length() - 1) == str1.charAt(0)) {
        ls1.add(str1);
        str = str1;
        break;
      }
    }
        ls.remove(str);
        getString(str); 
    }

    public static void main(String args[])throws Exception
    {
       Anagrams ob=new Anagrams();
       ob.input();
    }
}