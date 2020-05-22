import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile
{
        public static void main(String args[]) throws FileNotFoundException, IOException
        {
                Properties config = new Properties();
                config.load(new FileInputStream("config.properties"));

                int itemsPerPage = Integer.parseInt(config.getProperty("itemsPerPage"));
                int currentIndex = Integer.parseInt(config.getProperty("currentIndex"));
                int totalItemCount = Integer.parseInt(config.getProperty("totalItemCount"));

                if(currentIndex < totalItemCount)
                {
                        for(int iterator = 0; iterator < itemsPerPage; iterator++)
                        {
                                if(currentIndex < totalItemCount)
                                {
                                        //TODO Insert what ever processing of those batch operations here
                                        currentIndex++;
                                        continue;
                                }
                        }

                        config.setProperty("currentIndex", ((Integer)currentIndex).toString());

                        config.store(new FileOutputStream("config.properties"),null);
                }
        }
}