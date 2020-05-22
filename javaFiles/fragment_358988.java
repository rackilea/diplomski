public static int[] grades;
public static void main(String[] args) {
        readGrades();
}
public static void readGrades(){
    Scanner in=new Scanner(System.in);
    System.out.print("How many students there are : ");
    int numberOfStudents=in.nextInt();
    grades=new int[numberOfStudents];
    for(int i=0;i<numberOfStudents;i++){
        System.out.print("Enter the grade of the students : ");
        int grade=in.nextInt();
        grades[i]=grade;
     }
}