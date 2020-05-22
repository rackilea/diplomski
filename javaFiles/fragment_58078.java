public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    String[] course = new String [2]; //creating array
    int [] grade = new int [2];

    System.out.println("Input coursename and grade: ");

    for (int i = 0; i < course.length; i++) {
        course[i] = input.next();
        grade [i] = input.nextInt();
    }

   System.out.println(Arrays.toString(course)+(grade));
}