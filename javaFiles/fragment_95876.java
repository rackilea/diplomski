StudentBO country = new StudentBO();
Scanner sc = new Scanner(System.in);
int selection;
boolean exit = false;
while (!exit) 
{
System.out.println("Menu : ");
System.out.println("Type any number between 1 and 6");
System.out.println("1)Create a new student");
System.out.println("2)details specific student");
System.out.println("3)details of all students");
System.out.println("4)details of the student age details");
System.out.println("5)details of the student personal info");
System.out.println("6)Exit");
selection = sc.nextInt();
switch (selection)
        {
        case 1 :
            System.out.println("Enter studentName ");
            sc = new Scanner(System.in);
            String studentName= sc.nextLine();
            Student studentInfo = student.createStudent(studentName);
            System.out.println("Do you want to continue? Type Yes / No");
            Scanner sc1 = new Scanner(System.in);
            if (sc1.next().equalsIgnoreCase("no"))
                    exit = true;
                break;

            case 2 :

                break;
            case 3 :

                break;
            case 4 :

                break;
            case 5 :
                break;
            case 6 :
                break;
          }   
}