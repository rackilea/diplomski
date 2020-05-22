import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.InputStream;
    import java.io.OutputStream;

    public class FileInputOutputExample {

        public static void main(String[] args) throws Exception {

            try{
                    byte[] b = new byte[20];
                    InputStream is = new FileInputStream("in.txt");
                    OutputStream os = new FileOutputStream("out.txt");

                    int readBytes = 0;

                    while ((readBytes  = is.read(b)) != -1) {
                      os.write(b, 0, readBytes);
                    }
                    is.close();
                    os.close();

            }catch(IOException ioe){
                System.out.println("Error "+ioe.getMessage());
            }
         }
     }