private String courses = "";
private int tuitionBalance = 0;

public void enroll() {
    System.out.println("Enter course to enroll or \"Q\" to quit.");
    Scanner in = new Scanner(System.in);
    String course = in.nextLine();
    if (!course.equalsIgnoreCase("q")) {
        courses = courses + "\n" + course;
        tuitionBalance = tuitionBalance + costOfCourse;
        enroll(); 
    }
    else{//now it would come here only once after user has entered q after which it returns
    System.out.println("Enrolled in: " + courses);
    System.out.println("Tuition balance: " + tuitionBalance);
     }
    return;
}