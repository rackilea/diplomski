import java.io.FileInputStream;
import java.io.FileWriter;                                          
import java.io.IOException;                                         
import java.io.PrintWriter;                                         
import java.text.SimpleDateFormat;                                  
import java.util.Date;                                              
import java.util.Properties;                                        
import java.util.UUID;                                              
class FunctionLogging
{
    private String path;                                           
    private boolean appendToFile = false;                          

    public FunctionLogging(String file_path, boolean append_value)
    {
        path = file_path;                                         
        appendToFile = append_value;
    }
    public void writeToFile(int logType, String textLine) throws IOException
    {
        FileInputStream propFile = new FileInputStream("config.ini");
        Properties config = new Properties(System.getProperties());
        config.load(propFile);
        String tempLev = config.getProperty("loggingLevel");
        int logLevel = Integer.parseInt(tempLev);
        if(logType<=logLevel)
        {
            //This section is devoted to creating a timestamp of the instance the output string is created.
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat();
            format = new SimpleDateFormat("dd-MM-yyyy|HH:mm:ss:SSSSSS|");
            String timeStamp = format.format(date);
            SimpleDateFormat app = new SimpleDateFormat();
            app = new SimpleDateFormat("dd-MM-yyyy");
            String dateApp = app.format(date);
            String temp = UUID.randomUUID().toString();
            String unique = temp.substring(28);

            String[] messages = new String[4];
            messages[0]="DEBUG";
            messages[1]="INFO";
            messages[2]="Warning";
            messages[3]="FATAL";
            FileWriter logWriter = new FileWriter(path+dateApp+".log", appendToFile);
            PrintWriter loggerLines = new PrintWriter(logWriter);

            loggerLines.println(timeStamp+unique+"|"+messages[logType]+"|"+textLine);
            loggerLines.close();
        }
    }
}