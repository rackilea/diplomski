import java.io.*;

class PBT {

    public static void main(String args[]) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String courseCode[] = new String[3];
        String courseName[] = new String[3];
        int marks[] = new int[3];
        int creditHour[] = new int[3];
        String name, regNum, str;
        int tcreditHour;
        double tpointValue, gpa, cgpa, point, tpoint;

        System.out.print("Name : ");
        name = stdin.readLine();

        System.out.print("Registration Number : ");
        regNum = stdin.readLine();

        for (int x = 1; x < 3; x++) {
            System.out.println("-----------------------Please enter course " + x + " details-----------------------");
            System.out.print("Enter Course Code : ");
            courseCode[x] = stdin.readLine();

            System.out.print("Enter Course Name : ");
            courseName[x] = stdin.readLine();

            System.out.print("Enter Credit Hour(s) : ");
            str = stdin.readLine();
            creditHour[x] = Integer.parseInt(str);

            System.out.print("Enter marks : ");
            str = stdin.readLine();
            marks[x] = Integer.parseInt(str);

        }
        for (int x = 1; x < 3; x++) {
            System.out.println("\n\n\n***********************COURSE INFORMATION***********************");
            System.out.print("Course Code     " + courseCode[x]);
            System.out.print("Course Name     " + courseName[x]);
            System.out.print("Credit Hour       " + creditHour[x]);
            System.out.print("Marks      " + marks[x]);
            System.out.print("Point      ");
            System.out.print("Total Point");

            System.out.println("******************************************************************************");
            System.out.println("Total Point value : ");
            System.out.println("Total Credit Hour : ");
            System.out.println("GPA : ");
            System.out.println("CGPA :");
        }

    }
}