public static final String[] ISSUES = {
    "Global Warming",
    "Earth Quakes",
    "Stopping war",
    "Equal Rights",
    "Curing Cancer",};

public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    Random rand = new Random();
    int pollings = rand.nextInt(9) + 5;
    int [][] rates= new int[pollings][ISSUES.length];
    for (int i = 0; i < pollings; i++) {
        System.out.println("Person" + i);
        System.out.println("Rate these issues from 1-10");
        for (int j = 0; j < ISSUES.length; j++) {
            System.out.println(ISSUES[j]);
            rates[i][j] = console.nextInt();
        }
    }


     // ADDED
    int minRating = Integer.MAX_VALUE;
    int maxRating = Integer.MIN_VALUE;
    int minRatingIndex = -1;
    int maxRatingIndex = -1;
    for (int i = 0; i < ISSUES.length; i++) {
        System.out.print(ISSUES[i]+":");
        int rating = 0;
        for (int j = 0; j < pollings; j++) {
            System.out.print("\t"+rates[j][i]);
            rating += rates[j][i];
        }
        double average = ((double)rating)/pollings;
        System.out.println("\tavr: "+average);
        if (rating < minRating ){
            minRating = rating;
            minRatingIndex = i;
        }
        if (rating > maxRating ){
            maxRating = rating;
            maxRatingIndex = i;
        }
    }
    System.out.println("Max points:\t"+ISSUES[maxRatingIndex]+":\t"+maxRating+" points");
    System.out.println("Min points:\t"+ISSUES[minRatingIndex]+":\t"+minRating+" points");

    System.out.println();
}