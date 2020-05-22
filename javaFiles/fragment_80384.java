public class Main {


    public static void main(String[] args) {

    Course task1 = new Course();
    task1.Assignment1();

    }

 }

// The other class

class Course {

    CourseGrades[] course;

    public void Assignment1() {

        Scanner sc = new Scanner(System.in);


            System.out.println("Welcome to students database");
            System.out.println("Enter a to enter a student");
            char choice = sc.next().charAt(0);

            if (choice > 'z' || choice > 'a') {
                System.out.println("Invalid choice");

            } else {

                switch (choice) {

                    case 'a':
                        numbers();
                        break;
                    case 'b':
                        entering();
                        break;
                    case 'c':
                        printCourse();
                        break;

                }
            }
        }


    public void numbers() {

        System.out.println("Enter how many courses taken ");
        Scanner numbers = new Scanner(System.in);
        int courses = numbers.nextInt();
        CourseGrades[] course = new CourseGrades[courses];

    }

    public void entering() {

        for (int i = 0; i < course.length; i++) {
            System.out.println("Enter  coursename");
            Scanner sc = new Scanner(System.in);
            sc = new Scanner(System.in);
            String courseName = sc.nextLine();
            course[i] = new CourseGrades();
            course[i].setName(courseName);
            System.out.println("Enter grade");
            Scanner grade = new Scanner(System.in);
            course[i].setGrade(i);

        }
    }

    public void printCourse() {

        System.out.println("Printing out courses and grades");

        for (int i = 0; i < course.length; i++) {

            System.out.println(" name 2" + course[i].getName() + " grade" + course[i].getGrade());

        }

    }
}

// Getters and setters
class CourseGrades {

private String name;
private int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


}