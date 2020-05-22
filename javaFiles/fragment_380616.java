public class Answer3 {

    static int resCount = 3;
    static Scanner inPut = new Scanner(System.in);

    public static void main(String[] args) {
        calcAverage();
    }

    static void calcAverage() {
        int sum = 0;

        for (int i = 0; i < resCount; i++) {
          System.out.println("Please input exam " + i + " results");

          int res = inPut.nextInt();
          sum += res;

          String grade = determineGrade(res);
          System.out.println("Your grade is " + grade);
        }

        double avg = sum / resCount;
        System.out.println("The average of these exam results are " + avg));
    }

    static String determineGrade(int res) {
        if ( res > 84 && res <101 ) {
            return "HD";
        } else if ( res > 74 && res <85 ) {
            return "D";
        } else if ( res > 64 && res < 75 ) {
            return "C";
        } else if ( res > 49 && res < 65 ) {
            return "P";
        } else {
            return "F";
        }
    }

}