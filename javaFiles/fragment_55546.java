import java.io.File;
import java.util.Arrays;

public class Dir {
   static int indentLevel = -1;

   static void listPath(File path) {
   File files[]; 
   indentLevel++; 

   files = path.listFiles();

   Arrays.sort(files);
   for (int i = 0, n = files.length; i < n; i++) {
      for (int indent = 0; indent < indentLevel; indent++) {
         System.out.print("  ");
      }
      System.out.println(files[i].toString());
      if (files[i].isDirectory()) {

      listPath(files[i]);
    }
  }
indentLevel--; 
}

 public static void main(String args[]) {
    listPath(new File("/etc/yum.repos.d"));
 }
}