package threadFile;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
public class WriteToFile implements Runnable
{
    @SuppressWarnings("unused")
    private final String taskName;
    class WriteFile
    {
        private String path;
        private boolean append_to_file = false;

        public WriteFile(String file_path, boolean append_value)
        {
            path = file_path;
            append_to_file = append_value;
        }

        public void writeToFile(String timestamp) throws IOException
        {
            int i = 0;
            while(i<1)
            {
              FileWriter write = new FileWriter(path, append_to_file);
              Calendar current = Calendar.getInstance();
              int ms = current.get(Calendar.MILLISECOND);
              int minute = current.get(Calendar.MINUTE);
              int second = current.get(Calendar.SECOND);
              int hour = current.get(Calendar.HOUR_OF_DAY);
              int day = current.get(Calendar.DAY_OF_YEAR);
              int month = current.get(Calendar.MONTH)+1;
              int year = current.get(Calendar.YEAR);
              timestamp = day + "/" + month + "/" + year + " " + hour  + ":" + minute + ":" + second + ":" + ms;

              PrintWriter print_line = new PrintWriter(write);
              try
              {
                  Thread.sleep(250);
              }
              catch(InterruptedException e)
              {
                  Thread.currentThread().interrupt();
              }
              print_line.printf("%s" + "%n", timestamp);
              print_line.close();
            }
       }
    }
    //constructor
    public WriteToFile(String name)
    {
        taskName = name;
    }
    @SuppressWarnings("unused")
    public synchronized void run()
    {
        boolean loop = true;
        while(loop = true)
        {
            try
            {   
                String file_name = "C:/Users/wigginsm/Desktop/Log.txt";
                Calendar current = Calendar.getInstance();
                int ms = current.get(Calendar.MILLISECOND);
                int minute = current.get(Calendar.MINUTE);
                int second = current.get(Calendar.SECOND);
                int hour = current.get(Calendar.HOUR_OF_DAY);
                int day = current.get(Calendar.DAY_OF_YEAR);
                int month = current.get(Calendar.MONTH)+1;
                int year = current.get(Calendar.YEAR);
                String timestamp = day + "/" + month + "/" + year + " " + hour  + ":" + minute + ":" + second + ":" + ms;
                WriteFile data = new WriteFile(file_name, true);
                data.writeToFile(timestamp);
            }

            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}