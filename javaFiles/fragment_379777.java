import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import javax.swing.JOptionPane;

public class MkDirForMe {
   public static void main(String[] args) {
      try {
         String path = getProgramPath2();

         String fileSeparator = System.getProperty("file.separator");
         String newDir = path + fileSeparator + "newDir2" + fileSeparator;
         JOptionPane.showMessageDialog(null, newDir);

         File file = new File(newDir);
         file.mkdir();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static String getProgramPath2() throws UnsupportedEncodingException {
      URL url = MkDirForMe.class.getProtectionDomain().getCodeSource().getLocation();
      String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
      String parentPath = new File(jarPath).getParentFile().getPath();
      return parentPath;
   }
}