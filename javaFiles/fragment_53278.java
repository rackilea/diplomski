import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Day{

    public static void main( String[] args ){

    Scanner sc = new Scanner(System.in);
    System.out.println("Type a date in the form dd/MM/yyyy:");
    String date = sc.nextLine();
    SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    try {
        Date myDate = newDateFormat.parse(date);
        newDateFormat.applyPattern("EEEE dd MMM yyyy");
        String isDate = newDateFormat.format(myDate);
        String []myformat=isDate.split(" ");
        System.out.println(myformat[2]);
        System.out.println(myformat[1]);
        System.out.println(myformat[3]);
        System.out.println(myformat[0]);

        } catch (Exception e) {
        System.out.println("Error. Date is in the wrong format.");
    }
    }
}