package mypackage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.ChronoUnit;


public class DataUtil {

    public static void main(String[] args) {
        List<String> weeks = new ArrayList<>();

        LocalDate firstDayOfMonth = LocalDate.of(2016, 12 , 1);
        LocalDate firstWeekendOfMonth= firstDayOfMonth.with( TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));

        long firstWeekGap = ChronoUnit.DAYS.between(firstDayOfMonth , firstWeekendOfMonth) ;

        String daysInWeek = buildDaysInWeek(1,12,2016);
        weeks.add("{" + daysInWeek +"}");


        for ( int i = ((int)firstWeekGap +1 )  ; i <= 31 ; i = i+7  )
        {
            daysInWeek = buildDaysInWeek(i,12,2016);
            weeks.add("{" + daysInWeek +"}");

        }

        System.out.println(  " weeks " + weeks);


    }

    private static String buildDaysInWeek(int date,int month, int year)
    {
        StringBuffer daysInWeek = new StringBuffer();

        LocalDate startDate = LocalDate.of(year , month , date);

        daysInWeek.append(startDate.getDayOfMonth());

        LocalDate endOfWeek = startDate ;
        while (  endOfWeek.getDayOfWeek() != DayOfWeek.SATURDAY )
        {
            endOfWeek = endOfWeek.plusDays(1);
            daysInWeek.append(",");
            daysInWeek.append(endOfWeek.getDayOfMonth());
        }

        return daysInWeek.toString();
    }
}