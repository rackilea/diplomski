/**
 * Created by chenzhongpu on 23/10/2015.
 */
import java.util.Scanner;

public class Birthdays {
    private static int DAYS_YEAR = 365;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter today's date (month day): ");
        int z = scanner.nextInt();
        int y = scanner.nextInt();
        int currentDays = absoluteDay(z, y);
        System.out.println("Today is " + z + "/" + y + "/2016, day #" + currentDays + " of the year");

        System.out.print("Please enter person #1's birthday (month day): ");
        int j = scanner.nextInt();
        int k = scanner.nextInt();
        int birthDayDays1 = absoluteDay(j, k);
        int nextBirthdays1 =
                birthDayDays1-currentDays >= 0 ? birthDayDays1-currentDays: DAYS_YEAR - (currentDays-birthDayDays1);
        System.out.println(j + "/" + k + "/2016. Your next birthday is in "
                + nextBirthdays1 + " day(s)");

        System.out.print("Please enter person #2's birthday (month day): ");
        int q = scanner.nextInt();
        int w = scanner.nextInt();
        int birthDayDays2 = absoluteDay(q, w);
        int nextBirthdays2 =
                birthDayDays2-currentDays >= 0 ? birthDayDays2-currentDays: DAYS_YEAR - (currentDays-birthDayDays2);
        System.out.println(q + "/" + w + "/2016. Your next birthday is in "
                + nextBirthdays2 + " day(s)");

        if(nextBirthdays1 > nextBirthdays2){
            System.out.println("#2 is sooner");
        }else if(nextBirthdays1 < nextBirthdays2){
            System.out.println("#1 is sooner");
        }else{
            System.out.println("equal");
        }

    }

    private static int absoluteDay(int month, int day){
        int[] days = {0, 0, 31, 60, 91, 121, 91, 121, 152, 182,
        213, 244, 274, 305, 335};
        return days[month] + day;
    }
}