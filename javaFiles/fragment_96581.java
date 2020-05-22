[stephen@blackbox tmp]$ cat Test.java 
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> myTestObj = new HashMap<Integer,String>();

        myTestObj.put(0,"zero");
        myTestObj.put(1,"one");
        myTestObj.put(2,"two");
        myTestObj.put(3,"three");
        myTestObj.put(13,"thirteen");
        myTestObj.put(14,"fourteen");
        myTestObj.put(15,"fifteen");

        myTestObj.put(16,"sixteen");
        myTestObj.put(17,"senventeen");

        System.out.println(myTestObj);
    }
}

[stephen@blackbox tmp]$ javac Test.java 
[stephen@blackbox tmp]$ java Test
{0=zero, 16=sixteen, 1=one, 17=senventeen, 2=two, 3=three, 13=thirteen, 14=fourteen, 15=fifteen}
[stephen@blackbox tmp]$