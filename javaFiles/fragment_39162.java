package dummy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter; 
import java.io.UnsupportedEncodingException;

public class WrongWriter {
    static File wrongFile = new File("C:/Users/utente/Desktop/wrongFile.txt");
    static File rightFile = new File("C:/Users/utente/Desktop/rightFile.txt");


    public static void main(String[] args) throws IOException {

        byte[] wrongBytes = new byte[]{
                73, 76, 32, 82, 73, 84, 82, 79, 86, 79, 32, 65, 76, 32, 49, 0, 32, 80, 73, 65, 78, 79, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32
                };

        if (CharacterChecker.isISO_8859_1(wrongBytes)) {
            write(wrongFile, wrongBytes) ;          
        } else{
            System.out.println("Bad input");
        }

        byte[] rightBytes = "IL RITROVO AL 1° PIANO".getBytes("ISO-8859-15");

        write(rightFile, rightBytes) ;
    }



    static void write(File file, byte[] bytes) throws IOException{
        OutputStreamWriter stream = null; //10227
        stream =  new OutputStreamWriter( new FileOutputStream( file )  , "ISO-8859-15"); 
        stream.write( new String(  bytes,  "ISO-8859-15" ) ); 
        stream.flush();
        stream.close();

    }

}
class CharacterChecker {


    static public boolean isISO_8859_1(byte[] bytes) throws UnsupportedEncodingException{ 

        for(int i=0;i< bytes.length;i++)
           {
               if( 
                      ( bytes[i]<32 && bytes[i] >=0) 
                      || (bytes[i]<-65 && bytes[i]>-69)
                      || bytes[i]==-72
                      || bytes[i]==-76 
                      || bytes[i]==-88 
                      || bytes[i]==-90 
                      || bytes[i]==-92
                      ) {
                   return false; 
               }

           }

        return true;
    }

    static public boolean isISO_8859_1(String s) throws UnsupportedEncodingException{
        byte[] bytes = s.getBytes("ISO-8859-1"); 

        return isISO_8859_1(bytes);
    }


    static public String replaceNotISO_8859_1_characters(String s, char chracter) throws UnsupportedEncodingException{
        String cString = Character.toString(chracter);
        byte sobs = cString.getBytes("ISO-8859-1")[0];

        byte[] bytes = s.getBytes("ISO-8859-1");

        for(int i=0;i< bytes.length;i++)
           {
               if( 
                      ( bytes[i]<32 && bytes[i] >=0) 
                      || (bytes[i]<-65 && bytes[i]>-69)
                      || bytes[i]==-72
                      || bytes[i]==-76 
                      || bytes[i]==-88 
                      || bytes[i]==-90 
                      || bytes[i]==-92
                      ) {
                   bytes[i] = sobs;
               }

           }

        return new String(bytes,"ISO-8859-1");
    }


}