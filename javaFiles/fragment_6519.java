import java.io.*;

    public class WriteBinary {

      public static void main (String[] args) {
        int[] data = {
          1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        String fname = "myfile.bin";
        try
        {
          System.out.println("Opening " + fname + "...");      
          FileOutputStream fos = 
            new FileOutputStream(fname);
          int ibyte;
          for (int i = 0; i < data.length; i++) {
            ibyte = ((data[i] >>> 24) & 0xff); fos.write(ibyte);
            ibyte = ((data[i] >>> 16) & 0xff); fos.write(ibyte);
            ibyte = ((data[i] >>> 8) & 0xff); fos.write(ibyte);
            ibyte = (data[i] & 0xff); fos.write(ibyte);
          }
          fos.close();
          System.out.println("File write complete.");      
        }
        catch (IOException e) {
          System.out.println ("I/O error: " + e.getMessage());
        }
      }
    }