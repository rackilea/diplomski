import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStreamDemo {
   public static void main(String[] args) throws IOException {

      InputStream is = null;
      DataInputStream dis = null;
      FileOutputStream fos = null;
      DataOutputStream dos = null;
      byte[] b = {4,124,119,114,125,45,76,83,84};

      try{
         // create file output stream
         fos = new FileOutputStream("c:\\test.txt");

         // create data output stream
         dos = new DataOutputStream(fos);

         // for each byte in buffer
         for(byte j:b)
         {
            // write byte to the output stream
            dos.writeByte(j);
         }

         // force data to the underlying file output stream
         dos.flush();

         // create file input stream
         is = new FileInputStream("c:\\test.txt");

         // create new data input stream
         dis = new DataInputStream(is);

         // available stream to be read
         while(dis.available()>0)
         {
            // reads characters encoded with modified UTF-8
            int k = dis.read();

            // print
            System.out.print(k+" ");

            // skips 1 by
            dis.skipBytes(1);
         }
      }catch(Exception e){
         // if any error occurs
         e.printStackTrace();
      }finally{

         // releases all system resources from the streams
         if(is!=null)
            is.close();
         if(dis!=null)
            dis.close();
         if(fos!=null)
            fos.close();
         if(dos!=null)
            dos.close();
      }
   }
}