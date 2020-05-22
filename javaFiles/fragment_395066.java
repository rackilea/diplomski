package staticimport;
import java.util.Random;

public class DataGen {
    public class Options {
        public static final int OPTION1 = 1;
        public static final int OPTION2 = 2;
        public static final int OPTION3 = 4;
    }

    private static Random gen = new Random();

    public static String generateString(int n, int options) // <-------
    {
        if (options == Options.OPTION1)
        {
            //...
        }
        else if (options == (Options.OPTION1 | Options.OPTION3))
        {
            //...
        }

        //...

        return null;
    }
}