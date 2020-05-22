import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingFee {

    private static long hoursDifference(LocalDateTime ldt1, LocalDateTime ldt2) {
        long minutesDiff = ChronoUnit.MINUTES.between(ldt1, ldt2);
        long hoursDiff = Math.round(Math.ceil(minutesDiff/60.0));
        return hoursDiff;
    }

    public static long hoursDifference(
                                int startDay, int startMonth, int startYear, int startHour, int startMinute, 
                                int endDay, int endMonth, int endYear, int endHour, int endMinute) {
        return hoursDifference(
                    LocalDateTime.of(startYear, startMonth, startDay, startHour, startMinute), 
                    LocalDateTime.of(endYear, endMonth, endDay, endHour, endMinute));
    }

    public static int determineDayCycle(int dayTimeIntervalStart, int nightTimeIntervalLateStart) {
        return nightTimeIntervalLateStart - dayTimeIntervalStart;
    }

    public static void main(String[] args) {
        // Hourly rates
        int dayTimePricePerHour = 5;
        int nightTimePricePerHour = 10;

        // Rate intervals
        int dayTimeIntervalStart = 6;
        int nightTimeIntervalLateStart = 18;

        // Counted hours per rate
        int dayHoursTotal = 0;
        int nightHoursTotal = 0;

        // Start date and time
        int startYear = 2019;
        int startMonth = 1;
        int startDay = 1;
        int startHour = 20;
        int startMinute = 50;

        // End date and time
        int endYear = 2019;
        int endMonth = 1;
        int endDay = 3;
        int endHour = 2;
        int endMinute = 49;

        // Calculate the hours difference
        long hourDiff = hoursDifference(
                startDay, startMonth, startYear, startHour, startMinute, 
                endDay, endMonth, endYear, endHour, endMinute);
        System.out.println("Hour difference found: "+ hourDiff);

        // Handle parking for full days
        if (hourDiff > 24) {
            int dayCycle = determineDayCycle(dayTimeIntervalStart, nightTimeIntervalLateStart);
            long fullDays = hourDiff / 24;
            nightHoursTotal += (24-dayCycle)*fullDays;
            dayHoursTotal += dayCycle*fullDays;
            hourDiff = hourDiff % 24;
        }

        // Handle the parking for less than full day
        while (hourDiff > 0) {
            if (startHour < dayTimeIntervalStart) { // Before the day interval -> night
                nightHoursTotal++;
            } else if(startHour < nightTimeIntervalLateStart) { // Before the night interval -> day
                dayHoursTotal++;
            } else { // After the day interval -> night
                nightHoursTotal++;
            }
            startHour++;
            if (startHour > 23) // At midnight reset the hour to 0
                startHour = 0;
            hourDiff--;
        }

        System.out.println("Day hours: "+ dayHoursTotal);
        System.out.println("Night hours: "+ nightHoursTotal);
        System.out.println("Total hours: "+ (dayHoursTotal + nightHoursTotal));
        System.out.println("Day rate charged at "+ dayTimePricePerHour +": "+ (dayHoursTotal * dayTimePricePerHour));
        System.out.println("Night rate charged at "+ nightTimePricePerHour +": "+ (nightHoursTotal * nightTimePricePerHour));
        System.out.println("Total rate charged: "+ ((dayHoursTotal * dayTimePricePerHour) + (nightHoursTotal * nightTimePricePerHour)));
    }
}