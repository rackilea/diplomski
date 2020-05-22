import java.util.Iterator;
import java.util.LinkedList;

public class TestClass {
    public static void main(String[] args) {

        WeatherMonitor wM = new WeatherMonitor();

        DailyReadings dR = new DailyReadings(1,1,2020, 10, -20);
        wM.addDailyReport(dR);

        dR = new DailyReadings(1,2,2020, 10, -21);
        wM.addDailyReport(dR);

        dR = new DailyReadings(1,3,2020, 11, -20);
        wM.addDailyReport(dR);

        //...

        System.out.println(wM.averageHighForMonth(1, 2020));
        System.out.println(wM.averageLowForMonth(1, 2020));

    }
}


class DailyReadings {
    int day;
    int month;
    int year;
    int highTemperature;
    int lowTemperature;

    public DailyReadings(int day, int month, int year, int highTemperature, int lowTemperature){

        this.day = day;
        this.month = month;
        this.year = year;
        this.highTemperature = highTemperature;
        this.lowTemperature= lowTemperature;
    }
}

class WeatherMonitor {

    LinkedList<DailyReadings> Readings = new  LinkedList<DailyReadings>();

    int averageHighForMonth (int month, int year) {
        int tempHighAvg = 0;
        int count = 0;
        Iterator<DailyReadings> it =  Readings.iterator();
        DailyReadings tmp;
        while( (tmp = it.next()) != null) {
            if (tmp.month == month && tmp.year == year) {
                tempHighAvg += tmp.highTemperature;
                count++;
            }
        }
        return tempHighAvg / count;
    }

    int averageLowForMonth (int month, int year) {
        int tempLowAvg = 0;
        int count = 0;
        Iterator<DailyReadings> it =  Readings.iterator();
        DailyReadings tmp;
        while( (tmp = it.next()) != null) {
            if (tmp.month == month && tmp.year == year) {
                tempLowAvg += tmp.lowTemperature;
                count++;
            }
        }
        return tempLowAvg / count;
    }

    void addDailyReport(DailyReadings dR) {
        Readings.add(dR);
    }
}