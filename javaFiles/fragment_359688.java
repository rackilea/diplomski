import java.util.Scanner;

class Course {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of courses");
        int no_of_courses = sc.nextInt(); // number of strings
        String a[] = new String[no_of_courses]; // do not assume when you have proper data.
        if (no_of_courses <= 0)
            System.out.println("Invalid Range");
        else {
            System.out.println("Enter course names:");
            for (int i = 0; i < no_of_courses; i++) {
                a[i] = sc.next(); // accepting string inputs
            }
            System.out.println("Enter the course to be searched:");
            String search = sc.next(); // entering a string to search
            boolean flag = false;
            for (int i = 0; i < no_of_courses; i++) {
                if (a[i].equals(search)) // I feel the problem is here
                {
                    flag = true;//do not print here. just decide whether course is available or not
                    break;
                }
            }
            //at the end of for loop check your flag and print accordingly.
            if(flag) {
                System.out.println(search + "course is available");
            }else {
                 System.out.println(search + "course is not available");
            }
        }

    }
}