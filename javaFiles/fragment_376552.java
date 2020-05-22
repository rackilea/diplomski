import java.util.Date

public class ComparatorExample {
private static class DateComparator implements Comparator<Date> {

    @Override
    public int compare(String s1, String s2) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(s1);
        Date date2 = sdf.parse(s2);

        System.out.println(sdf.format(date1));
        System.out.println(sdf.format(date2));

        if(date1.compareTo(date2)>0){
            return 1;
        }else if(date1.compareTo(date2)<0){
            return -1;
        }else if(date1.compareTo(date2)==0){
            return 0;
        }

    }

}
    }