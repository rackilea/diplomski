import java.io.IOException;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class TrimCols extends EvalFunc<String> {

public String exec(Tuple input) throws IOException {

    if (input != null && input.size() != 0) 
    {
        String line = input.toString();
        String [] items = line.split(","); -- Use whatever delimiter your columns are separated by.
            try 
            {
                StringBuilder s = new StringBuilder();
                for(int i=0;i < items.length;i++)
                {
                    if(items[i] != null && !items[i].toString().isEmpty() && items[i].Length > 10000)
                        s.append(items[i].substring(0,10000));
                    else
                        s.append(items[i]);
                    if(i < items.length-1)
                        s.append(","); -- Add the delimiter again,You will need this to split the trimmed cols in your pig script
                }
                return s.toString();    

            } catch (Exception e) 
            {
                return line;
            }
    }
    else
        return "INPUT_NULL"; -- return whatever you want,so that you can handle this in your pigscript
  }
}