public static void main(String[] args) {           
    Scanner input = new Scanner(System.in);
    int numOfStu;
    String[] students;
    double[] scores;

    System.out.println("Enter the number of students being recorded: ");
    numOfStu = input.nextInt();
    students = new String[numOfStu];
    scores = new double[numOfStu];

    System.out.println("Enter students' names: ");
    for (int i = 0; i < students.length; i++) {
           students[i] = input.next();
    }
    for (int i = 0; i < students.length; i++) {
          System.out.print("Enter score for " + students[i] + ": ");
          scores[i] = input.nextDouble();
    }
 }