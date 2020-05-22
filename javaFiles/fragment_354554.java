package argsbuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ArgsBuilder
{

public static void main(String[] args)
{
    checkIfRunning(args);
}

private static void checkIfRunning(String[] args)
{
    buildFile(args);

    ProcessBuilder pb = new ProcessBuilder("core.exe"); //core.exe is a .exe wrapper with the  .jar audioplayer in it
    try
    {
        Process p = pb.start();
    }catch (IOException f){System.out.println(f);}
}

private static void buildFile(String[] args)
{
    try
    {
        boolean notdone = true;
        int i=0;
        File f;
        while(notdone)
        {
            f = new File("arg" + i + ".txt");
             if(f.exists())
             { 
                 i++;
             }
             else
             {
                PrintStream out = new PrintStream(new FileOutputStream(new File("Folder Location" + "arg" + i + ".txt")));
                System.setOut(out);
                System.out.println(args[0]);
                notdone = false;
             }
        }
    }catch(Exception g){System.out.println(g);}
}}