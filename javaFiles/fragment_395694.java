//import java.awt.Rectangle; // you probably autocompleted this line, since you created your own Rectangle class for console outputs
public class Rectangle {
    public double x;
    public double y;
    public double width, height;

    public Rectangle(double x, double y, double w, double h) {
           this.x = x;
           this.y = y;
           width = w;
           height = h;
   }
   public static void main(String[] args) {
       Rectangle box = new Rectangle (100, 50, 50, 60);
       System.out.println(box);

       System.out.println("Part 1:");
       System.out.println("-------");
       System.out.println("CREATING AN EMPTY Rectangle, SETTING ITS width TO 50, " +
                          "ITS height TO 60, AND ITS TOP LEFT CORNER TO (100, 50)");
       // Code for Part 1 goes here




       System.out.println("Part 2:");
       System.out.println("-------");
       System.out.println("TESTING THE PERIMETER OF THE RECTANGLE "
                        + "CREATED IN PART 1 ABOVE");
       // Code for Part 2 goes here.  Use the same Rectangle
       // you used Part1

       // define a String reference called river and initialize it
       // to Mississippi.  Read the API to figure out which method 
       // to use to get the desired effect.
       System.out.println("Part 3:");
       System.out.println("-------");
       System.out.println("INITIALIZING river to Mississippi AND REPLACING "
                        + "EACH i to ! AND EACH s TO $");
       // code for Part 3 goes here


       System.out.println("Part 4:");
       System.out.println("-------");
       System.out.println("CONSTRUCTING A StringBuilder OBJECT INITIALIZED "
                        + "TO desserts AND REVERSING IT");
       // code for Part 4 goes here


       System.out.println("Part 5:");
       System.out.println("-------");
       System.out.println("CONSTRUCTING A Random OBJECT TO PLAY LOTTERY BY GENERATING ");
       System.out.println("6 RANDOM INTEGERS BETWEEN 1 and 49 (BOTH INCLUSIVE)");
       //code for Part 5 goes here

       System.out.println("Part 6:");
       System.out.println("-------");
       System.out.println("ADDING ONE DAY TO 2/28/2019, 2/28/2020, 2/28/2021 " +
                          "AND 2/28/2022 AND PRINTING THEM");
       // code for Part 6 goes here
   }
}