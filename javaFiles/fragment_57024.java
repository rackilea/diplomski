import java.text.*;
import java.util.*;

public class Test
{
    // Just for the sake of a simple test program!
    public static void main(String[] args) throws Exception
    {
        NumberFormat format = NumberFormat.getInstance(Locale.US);

        Number number = format.parse("835,111.2");
        System.out.println(number); // or use number.doubleValue()
    }
}