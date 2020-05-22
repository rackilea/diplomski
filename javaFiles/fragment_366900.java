import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Parse {

    /**
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("(comment:file_02389.txt,lastmodified:Wed Oct 10 19:10:49)").append("\n");
        sb.append("(comment:file_02342.txt,lastmodified:Wed Oct 10 17:16:08)").append("\n");
        sb.append("(comment:file_02315.txt,lastmodified:Wed Oct 10 18:45:12)").append("\n");
        sb.append("(comment:file_02344.txt,lastmodified:Wed Oct 10 08:31:01)").append("\n");

            //create a date format that can parse dates formatted in the file
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss");

            //read the file into an array of lines (or read one line at a time)
        String[] lines = sb.toString().split("\n");

            //create an array of pair objects to hold the line as well as the date
        List<Pair> list = new ArrayList<Pair>();


        for(int i=0;i<lines.length;i++){
                    //get the date component of the line
            String dateString = lines[i].substring(lines[i].length()-20, lines[i].length()-1);

            Pair pair = new Pair();
            pair.date = sdf.parse(dateString); 
            pair.line = lines[i];
            list.add(pair);
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1).line);
    }
}
class Pair implements Comparable<Pair>{

    public Date date;
    public String line;

    @Override
    public int compareTo(Pair o) {
        return date.compareTo(o.date);
    }

}