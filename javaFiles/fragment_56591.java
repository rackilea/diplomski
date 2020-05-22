import java.util.*;
public class Tester {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
                Lesson [] lessonList = new Lesson [4];
                lessonList[0] =  new Lesson ("Zumba", "Monday & Wednesday", 100, 3.4);
                lessonList[1] = new Lesson("Spin", "Tuesday & Thursday", 80, 3.9);
                lessonList[2] = new Lesson("Yoga", "Sunday", 83, 4.0);
                lessonList[3] = new Lesson("BodySculpt", "Friday and Saturday", 90, 3.85);


                for(int count = 0; count < lessonList.length; count++){
                    System.out.println((count + 1) + ". " + lessonList[count]); 
                }

                System.out.println("Please select between 1 - 4 for the lessons ");
                int selection = sc.nextInt();
                selection -= 1;
                while(selection >lessonList.length | selection < 0) {
                    System.out.println("Can you please re-enter selection  .");
                    selection = sc.nextInt();
                }
                System.out.println((selection + 1) + ". " + lessonList[selection]); 
    }
}

public class Lesson {

    private String lessonTitle;
    private String lessonDate;
    private double lessonPrice;
    private double rating;

    public Lesson() { //default constructor
        this.lessonTitle = null;
        this.lessonDate = null;
        this.lessonPrice = 0;
        this.rating = 0;
    }

    public Lesson (String title, String date, double price, double rate) { //second constructor
        this.lessonTitle = title;
        this.lessonDate = date;
        this.lessonPrice = price;
        this.rating = rate;
    }

**//When you want to print a class, you must need a toString method defined right**

    public String toString () {
        return "Lesson Title: " + this.lessonTitle + ", Lesson Date: " + this.lessonDate + ", $" + this.lessonPrice + ", Rate: " + this.rating;
    }

}