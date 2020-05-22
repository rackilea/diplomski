import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Test
{

    public static void main(String[] args)
    {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY);
        DecimalFormat df = (DecimalFormat)nf;
        String output = df.format(123456789.01);
        System.out.println(output);
    }
}