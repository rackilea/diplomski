import java.io.*;
   class Copy {
   public final static String dst = "/home/ubuntu/1/1";
   public final static String src = "/home/ubuntu/assets/ipt.txt";
   static File fileSrc=new File(src);
   static File fileDst=new File(dst);
   public static void main(String[] args) throws IOException {
       System.out.println("main");
       Copy.copy(fileSrc,fileDst);
   }
   public static void copy(File src, File dst) throws IOException {
      InputStream in = new FileInputStream(src);
      try {
         OutputStream out = new FileOutputStream(dst);
         try {
            // Transfer bytes from in to out
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
               out.write(buf, 0, len);
            }
         } finally {
            out.close();
         }
      } finally {
         in.close();
      }
   }
}