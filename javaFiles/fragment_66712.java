import org.apache.pig.FilterFunc;
import java.io.IOException;
import org.apache.pig.data.Tuple;


public class FilterUDF extends FilterFunc {
    public Boolean exec(Tuple input) throws IOException {
        if (input == null || input.size() == 0)
            return null;

        int val1 = input.get(0)  // gets val1 from pig
        int val2 = input.get(1)  // gets val2 from pig

    /*rest of code*/
    }
}