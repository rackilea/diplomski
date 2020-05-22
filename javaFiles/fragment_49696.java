import java.util.Arrays;     
import java.util.List;  
import java.util.ArrayList;  

public class StringArrayTest  
{
    public static void main(String[] args)  
    {
        String title[] = { "Cup Cake", "Donut", "Eclair", "Froyo",
        "Ginger Bread", "Honey Comb", "Icecream Sandwich", "Jelly Bean" };

        String desc[] = { "version: 1.5", "version: 1.6",
        "version: 2.0 & 2.1", "version: 2.2", "version: 2.3",
        "version: 3.0", "version: 4.0", "version: 4.1" };

        private int thumb[] = {3,4,7,8,10,11,15,16};

        List<String> nameList = new ArrayList(Arrays.asList(title));
        nameList.addAll(Arrays.asList(desc));
        nameList.addAll(Arrays.toString(thumb));
   }  
}