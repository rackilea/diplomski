public class SumSeries {

    public static void main(String[] args) {
        System.out.println(sumSeries());
    }

    // if you want to keep the argument-less method in main but want to calculate
    // the sum from 1 - 10 nevertheless.
    public static double sumSeries() {
      return sumSeries(10);
    }

    public static double sumSeries(int i){
        if (i == 0) {
            return 0;
        }
        else {
            // The cast to double is necessary. 
            // Else you will do an int-division here and get 0.0 as result.
            // Note the invocation of sumSeries here inside sumSeries.
            return ((double)i / (2 * i + 1)) + sumSeries(i-1);
        }
    }
}