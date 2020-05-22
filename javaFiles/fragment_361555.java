import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

class Main
{
    public static void main(final String[] argv)
    {
        Reader reader;

        reader = null;

        try
        {
            final Properties properties;

            reader = new BufferedReader(
                            new FileReader(argv[0]));
            properties = new Properties();
            properties.load(reader);
            System.out.println(properties);
        }
        catch(final IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(reader != null)
            {
                try
                {
                    reader.close();
                }
                catch(final IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }
}