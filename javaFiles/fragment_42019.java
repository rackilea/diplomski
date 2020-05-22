package max;

public class Max {


public static void main(String[] args) {

    int a[]= {50, 30, 45, 78, 96};

    System.out.println(getLargest(a));

}// close main


public static int getLargest(int t[]) {

    int maximum = t[0];   // start with the first value

    for (int i = 1; i < t.length; i++) {

        if (t[i] > maximum) {

            maximum = t[i];   // new maximum

        }//close if

    }//close for

    return maximum;
}//end method max