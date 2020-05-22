import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main
{
    public static void main(final String[] argv)
    {
        final File file;

        file = new File(argv[0]);

        try
        {
            final Scanner scanner;

            scanner = new Scanner(file);

            while(scanner.hasNextLine())
            {
                if(scanner.hasNext(".*,"))
                {
                    String key;
                    final String value;

                    key = scanner.next(".*,").trim();

                    if(!(scanner.hasNext()))
                    {
                        // pick a better exception to throw
                        throw new Error("Missing value for key: " + key);
                    }

                    key   = key.substring(0, key.length() - 1);
                    value = scanner.next();

                    System.out.println("key = " + key + " value = " + value);
                }
            }
        }
        catch(final FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }
}