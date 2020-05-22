public static void main(String[] args) {

    Scanner in = new Scanner(System.in);


    System.out.print("How many times? ");
    int numOfTimes = in.nextInt();
    System.out.println("\n");

    ArrayList<Double> hours = new ArrayList<>();
    ArrayList<Double> minutes = new ArrayList<>();
    double minTotal = 0;

    for (int i = 1; i <= numOfTimes; i++){

      System.out.println("What Time (military time):  ");
      System.out.print("Hour  ");
      double hrs1 = in.nextDouble();
      System.out.print("Minute  ");
      double min1 = in.nextDouble();

      hours.add(hrs1);
      minutes.add(min1);
    }

    //calculate average
    double avgHr1 = 0;
    double timeMin1 = 0:
    for (int i = 0; i < hours.size(); i++) {
      double hour = hours.get(i);
      double minute = minutes.get(i);

      //ToDo: calculate average so far

    }

    System.out.println(avgHr1+":"+timeMin1 + " P.M");
  }