import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test2{

    public static void main(String[] args) throws ParseException {    
            String formatted =    "2014-04-28 ,2014-04-28 ,"
                                + "2015-10-26 ,2015-10-30 ,"
                                + "2015-07-30 ,2015-07-30 ,"
                                + "2015-04-14 ,2015-04-20 ,"
                                + "2013-11-14 ,2013-11-18 ,"
                                + "2014-04-16 ,2014-04-22 ,"
                                + "2014-11-19 ,2014-11-21 ,"
                                + "2019-10-01 ,2019-10-01 ";

            List<Long> diffs = getDifferences(formatted);
            System.out.println(diffs);
            double averageDiff = averge(diffs);
            System.out.println(averageDiff);
    }
    public static List<Long> getDifferences(String input) throws ParseException{
        List<Long> differences = new ArrayList<>();
        String[] dates = input.split(",");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i<dates.length; i = i+2){
            differences.add(differenceBetween(sdf.parse(dates[i+1]),sdf.parse(dates[i])));
        }
        return differences;
    }
    public static long differenceBetween(Date date1, Date date2){
        long MILLIS_PER_DAY = 24 * 3600 * 1000;
        long msDiff= date1.getTime() - date2.getTime();
        long daysDiff = Math.round(msDiff / ((double)MILLIS_PER_DAY));
        return daysDiff;
    }
    public static double averge(List<Long> diffs){
        double sum = 0;
        for(Long d : diffs){
            sum += d;
        }
        return sum/diffs.size();
    }
}