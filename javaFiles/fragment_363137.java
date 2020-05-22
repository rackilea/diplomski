import java.io.*;

public class Foo 
{

    public void readFile(File[] myFile) 
    {

       FileInputStream fiStream = null;
       BufferedInputStream biStream = null;
       DataInputStream diStream = null;
       foreach(File file in myFile)
       {

           try 
           {
               fiStream = new FileInputStream(file);

               biStream = new BufferedInputStream(fiStream);
               diStream = new DataInputStream(biStream);

               while (dis.available() != 0) 
               {
                System.out.println(dis.readLine());
               }

           } catch (IOException e)
           {
               e.printStackTrace();
           } finally 
           {
              try 
              {
                  fiStream.close();
                  biStream.close();
                  diStream.close();
              } catch (IOException ex)
              {
                  ex.printStackTrace();
              }
           }
       }
    }
}