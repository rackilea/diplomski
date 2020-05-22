import java.io.*;

public class Demo{

    public static void main(String[] args){
        File f = new File("abc.txt") ;

        try{
                System.setOut(new PrintStream( new FileOutputStream(f) ) ) ;
        }
        catch(FileNotFoundException fnfe){
                System.out.println(fnfe.getMessage()) ;
        }

        System.out.println("Hello\n") ;

        try{
                Process p = Runtime.getRuntime().exec("notepad.exe " + f.getPath()) ;
        }
        catch(IOException io){
                System.out.println(io.getMessage()) ;
        }
    }

}