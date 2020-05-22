import java.io.*;

public class Demo{

    public static void main(String[] args){

        File f = new File("Abc.java") ;
        PrintWriter writer = null;
        BufferedReader reader = null;
        InputStream pStream = null;

        try{
                // Open File Stream and write code
                writer = new PrintWriter( new FileOutputStream(f) );
                String javaCode = "public class Abc { \r\n" +
                                  "public static void main(String[] args) {\r\n" +
                                  "System.out.println(\"Hello World!\");\r\n" +
                                  "}\r\n" +
                                  "}\r\n";

                writer.println(javaCode) ;
                writer.close();

                // Run Javac to compile the code
                Process p = Runtime.getRuntime().exec("javac " + f.getPath()) ;
                p.waitFor();

                // status = 0 => Process executed without errors
                //        = 1 => Process executed with errors
                int status = p.exitValue();
                if( status ==  0 )
                {
                    pStream = p.getInputStream();
                }
                else
                {
                    pStream = p.getErrorStream();
                }

                // Display the output from the process
                reader = new BufferedReader(new InputStreamReader(pStream));
                String ln = null;
                while( (ln = reader.readLine()) != null )
                {
                    System.out.println(ln);
                }
        }
        catch(Exception ex){
                System.out.println(ex.getMessage()) ;
        }
        finally{
            try{
               if( writer != null ){writer.close();}
                if( pStream != null ){pStream.close();}
                if( reader != null ){reader.close();}
            }
            catch(Exception ex){
                System.out.println(ex.getMessage()) ;
            }
        }
    }
}