public class DoYourHomework {

    String[] name = new String[100];
    String[] gender = new String[100];
    String[] studentNo = new String[100];
    Double[] gpa = new Double[100];
    int menu = 0;
    int accountNumber = 0;

    public DoYourHomework() {
        Scanner in = new Scanner(System.in);
        menu = in.nextInt();
        switch (menu) {
        case 1:  {
        System.out.println("** Recording a new student");
        System.out.println("*** Please use lower case");
        in.nextLine(); // for solve skipping 

        String name = null;
        String number = null;
        String gender = null;
        double gpa = -1;

        System.out.print("Enter Student Name and Surname: ");
        name = in.nextLine();

        System.out.print("Enter Student Gender(m/f): ");
        gender = in.nextLine();

        System.out.print("Enter Student Number: ");
        number = in.nextLine();

        System.out.print("Enter Student GPA: ");
        gpa = in.nextDouble();

        registerNewStudent(name, gender, number, gpa);
        accountNumber++;


        System.out.println("New Student Recorded. There are ["+accountNumber+"] students in system.");
        System.out.println("");
        }
        }

    }

    private void registerNewStudent(String name2, String gender2,
            String number, double gpa2) {
        name[accountNumber] = name2;
        gender[accountNumber] = gender2;
        studentNo[accountNumber] = number;
        gpa[accountNumber] = gpa2;
    }

    public static void main(String[] args) {
        new DoYourHomework();
    }

}