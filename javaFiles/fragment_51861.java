import java.util.Scanner;

public class MonthCalendar {
   // method for determining # of days
   public static int numOfDays(int month, int year) {
      int numDays = 0;
      switch (month) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
         numDays = 31;
         break;
      case 4:
      case 6:
      case 9:
      case 11:
         numDays = 30;
         break;
      case 2:
         if (isLeap(year))
            numDays = 29;
         else
            numDays = 28;
            break;
      }
      return numDays;
   }

   // determine if leap year
   public static Boolean isLeap(int year) {
      if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
         return true;
      else
         return false;
   }

   // get month name from user int
   public static String getMonthName(int month) {
      String monthName = "j";
      switch (month) {
         case 1:
         monthName = "January";
         break;
         case 2:
         monthName = "February";
         break;
         case 3:
         monthName = "March";
         break;
         case 4:
         monthName = "April";
         break;
         case 5:
         monthName = "May";
         break;
         case 6:
         monthName = "June";
         break;
         case 7:
         monthName = "July";
         break;
         case 8:
         monthName = "August";
         break;
         case 9:
         monthName = "September";
         break;
         case 10:
         monthName = "October";
         break;
         case 11:
         monthName = "November";
         break;
         case 12:
         monthName = "December";
         break;
      }
      return monthName;
   }

   public static void main(String[] args) {
      //prompt user for month, year, and day
      Scanner input = new Scanner(System.in);
      System.out.println("Enter month (number), year, and day of the first date (number): ");
      System.out.println();
      int month = input.nextInt();
      int year = input.nextInt();
      int day = input.nextInt();
      int numDays = numOfDays(month, year);

      // print heading
      System.out.println("\t\t\t" + getMonthName(month) + " " + year);
      System.out.println("\t---------------------------------------------------");
      System.out.println("\tSun\tMon\tTue\tWed\tThu\tFri\tSat");

      // determine starting day of the week
      day %= 7;
      for (int b = 0; b <= day * 7; b++) {
        System.out.print(" ");
      }

      // print calendar
      for (int d = 1; d <= numOfDays(month, year); d++) {
         // format for single digits to line up with the first digit of two digit #'s'
         if (d < 10) {
              System.out.print(" ");
         }
         // go to next line if at end of week
         if (day % 7 == 0) {
             System.out.print("\t" + d + "\n");
         }
         // normal formatting for other days
         else {
             System.out.print("\t" + d);
         }   
         day++;
      }

   } 
}