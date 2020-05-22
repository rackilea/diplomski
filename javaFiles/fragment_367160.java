public class AvgTime {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);


    System.out.print("How many times? ");
    int numOfTimes = in.nextInt();
    System.out.println("\n");

    double hrTotal = 0;
    double minTotal = 0;

    for (int i = 1; i <= numOfTimes; i++){

      System.out.println("What Time (military time):  ");
      System.out.print("Hour  ");
      double hrs1 = in.nextDouble();
      System.out.print("Minute  ");
      double min1 = in.nextDouble();

      hrTotal += hrs1;
      minTotal += min1;
    }

    //calculate average
    double avdHr1 = hrTotal/numOfTimes;
    double timeMin1 = minTotal/numOfTimes;

    System.out.println(avgHr1+":"+timeMin1 + " P.M");
  }
}