import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) throws Exception 
    {

        Writer output; //to write the data into a file 
        String PathOfFile = "/home/pi/boot.log";
        //PrintWriter writer = new PrintWriter(PathOfFile , true /* append = true */)
        output = new BufferedWriter(new FileWriter(PathOfFile , true));
        Calendar Time = Calendar.getInstance(); //get the time 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        try 
        {
            System.out.println("Hello - the device is UP and running now :-)");
            output.append ("\r\n" + sdf.format(Time.getTime()) + "   Unit is UP\r\n " );
            output.close();

            System.exit(0);
        }

        catch (Exception e)
        {
            System.err.println(e);
            output.append (sdf.format(Time.getTime()) +  "    " + e );
            output.close();
        }
    }
}