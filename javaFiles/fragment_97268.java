public static void main(String[] args) {
    int i;
    int numStudents;
    System.out.print("Enter number of students: ");
    Scanner scanint = new Scanner (System.in);      
    numStudents = scanint.nextInt();
    int [] grades = new int [numStudents]; //the size we wanted
    for ( i = 0;  i < grades.length; ++i) //starting from 0, not 1.
    {
        System.out.println("Enter grade: ");
        grades[i] = scanint.nextInt();
    }
    //print the array - for checking out everyting is ok
    System.out.println(Arrays.toString(grades)); 
}