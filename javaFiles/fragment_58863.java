import java.util.Calendar;

public class test {

    public static void main(String[] args){

        Calendar today = Calendar.getInstance();
        Calendar problemDate = Calendar.getInstance();

        today.set(2013, 01, 05);
        problemDate.set(2012, 11, 05);
        System.out.println(today.getTime());
        System.out.println(problemDate.getTime());

        // This might need further validation to make sure today >= problemDate
        int diffYear = today.get(Calendar.YEAR) - problemDate.get(Calendar.YEAR);
        int differenceInMonths = diffYear * 12 + today.get(Calendar.MONTH) - problemDate.get(Calendar.MONTH);
        //int differenceInMonths = today.get(Calendar.MONTH) - problemDate.get(Calendar.MONTH);

        for(int i = 0; i <= differenceInMonths; i++) {
          int daysDifference;

          if (differenceInMonths == 0) {
             daysDifference = today.get(Calendar.DAY_OF_MONTH) - problemDate.get(Calendar.DAY_OF_MONTH);
          } else {
            if ( i == 0) { // first month
              daysDifference = problemDate.getActualMaximum(Calendar.DAY_OF_MONTH) - problemDate.get(Calendar.DAY_OF_MONTH);
            }
            else if( i == differenceInMonths ) { // last month
              daysDifference = today.get(Calendar.DAY_OF_MONTH);
            }
            else {
              Calendar cal= Calendar.getInstance();
              cal.set(Calendar.MONTH, problemDate.get(Calendar.MONTH) + i);
              daysDifference = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            } 
                  }

          System.out.println(daysDifference);
        }
    }
}