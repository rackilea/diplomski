import java.io.*;

public class Reader {
    public static void main(String[] args) {

        BufferedReader reader = null;
        StringBuilder randomstring =  new StringBuilder();
        try  {
             reader = new BufferedReader(new FileReader("file.txt"));


            String line = reader.readLine();
            while(line !=  null) {
                randomstring.append(line + '\n');

                 line = reader.readLine();
            }
        } catch(FileNotFoundException e){System.out.println("Error: "+e.getMessage());
        } catch(IOException e){System.out.println("Error: "+e.getMessage());
        }
        finally{
            try{
                reader.close();
            }catch(Exception E){}
        }
        System.out.println(randomstring.toString());
    }
}