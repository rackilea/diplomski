jcomeau@intrepid:/tmp$ cat test.java; java -cp test.jar test; jar tvf test.jar
import java.io.*;
public class test {
 public static void main(String[] args) {
  //System.out.println(test.class.getResource("data/level"));
  try {
   System.out.println(new File(test.class.getResource("data/level").getPath()));
   System.out.println(test.class.getResourceAsStream("data/level/test").read());
  } catch (Exception whatever) {
   System.err.println("error: " + whatever);
  }
 }
}
file:/tmp/test.jar!/data/level
116
     0 Thu Nov 11 00:36:14 PST 2010 META-INF/
    40 Thu Nov 11 00:36:14 PST 2010 META-INF/MANIFEST.MF
  1362 Thu Nov 11 00:35:46 PST 2010 test.class
     0 Wed Nov 10 07:53:18 PST 2010 data/
     0 Wed Nov 10 07:53:28 PST 2010 data/level/
     5 Wed Nov 10 07:53:28 PST 2010 data/level/test
jcomeau@intrepid:/tmp$